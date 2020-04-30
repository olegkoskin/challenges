package week5.string_in_binary_tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree.
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
public class StringInBinaryTreeV2 {

    /**
     * Breadth-first search.
     *
     * For each {@code depth} level, if the value of {@code arr} matches that of node, then
     * <ol>
     *     <li>if reached the end of the subtree and end of the {@code arr}, a valid sequence found, return {@code true};</li>
     *     <li>otherwise, put the children of current node into {@code Queue}, and continue to the next {@code depth} level of breadth search.</li>
     *     <li>repeat 1 & 2 until a valid sequence found; or no valid one till the end, return {@code false}.</li>
     * </ol>
     *
     * O(min(2 ^ m, n)) - time
     * O(n) - space
     *    where m = arr.length and n is total number of the nodes in binary tree.
     *
     * @param root tree root
     * @param arr sequence
     * @return true if a valid sequence is in such binary tree, otherwise false
     */
    public boolean isValidSequence(TreeNode root, int[] arr) {
        int length = arr.length;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int depth = 0; !queue.isEmpty() && depth < length; depth++) { // search depth level control
            for (int sz = queue.size(); sz > 0; sz--) { // search breadth control
                TreeNode node = queue.poll();

                if (node != null && node.val == arr[depth]) { // a matching node found
                    if (depth + 1 == length && node.left == null && node.right == null) { // match from root to a leave hence it's a valid sequence
                        return true;
                    }
                    queue.addAll(Arrays.asList(node.left, node.right)); // add into Queue its children for next depth level
                }
            }
        }
        return false; // no valid sequence
    }

}
