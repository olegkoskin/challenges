package week5.string_in_binary_tree;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 * <p>
 * Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given
 * string is a valid sequence in such binary tree.
 * <p>
 * We get the given string from the concatenation of an array of integers arr and the concatenation of all values of
 * the nodes along a path results in a sequence in the given binary tree.
 * <p>
 * Example 1:
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
 * Output: true
 * Explanation:
 * The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
 * Other valid sequences are:
 * 0 -> 1 -> 1 -> 0
 * 0 -> 0 -> 0
 * <p>
 * Example 2:
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
 * Output: false
 * Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 * <p>
 * Example 3:
 * Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
 * Output: false
 * Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequence.
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li>1 <= arr.length <= 5000</li>
 *     <li>0 <= arr[i] <= 9</li>
 *     <li>Each node's value is between [0 - 9].</li>
 * </ul>
 *
 * <b>Hint #1:</b> Depth-first search (DFS) with the parameters: current node in the binary tree and current position
 * in the array of integers.<p>
 * <b>Hint #2:</b> When reaching at final position check if it is a leaf node.
 */
public class StringInBinaryTree {

    /**
     * Depth-first search. Recursion approach.
     *
     * For each depth level, check:
     * <ol>
     *     <li>If reached the end of the current subtree or the input {@code arr}, or current node value does NOT match
     *     the value of arr, then current sequence is NOT valid, return {@code false};</li>
     *     <li>if current node is a leave, check if the end of {@code arr} reached, if yes it is a valid sequence,
     *     return {@code true}, otherwise {@code false};</li>
     *     <li>Other cases, increase the {@code index} by {@code 1} and recurse to the children; if both end up with {@code false},
     *     the result is {@code false}, otherwise {@code true}.</li>
     * </ol>
     *
     * @param root tree root
     * @param arr sequence
     * @return true if a valid sequence is in such binary tree, otherwise false
     */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode root, int[] arr, int index) {
        if (root == null || index >= arr.length) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return arr.length - 1 == index && arr[index] == root.val;
        }

        return arr[index] == root.val
                && (dfs(root.left, arr, index + 1) || dfs(root.right, arr, index + 1));
    }

}
