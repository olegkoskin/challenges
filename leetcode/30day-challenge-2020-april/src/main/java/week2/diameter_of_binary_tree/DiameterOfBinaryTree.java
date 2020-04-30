package week2.diameter_of_binary_tree;

/**
 * Diameter of Binary Tree.
 * <p>
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree
 * is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * <b>Example 1:</b>
 * Given a binary tree
 * <p>
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * <p>
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 *
 * <b>Example 2:</b>
 * Given a binary tree
 * <p>
 *              1
 *             / \
 *            2   3
 *           / \
 *          4   5
 *         / \   \
 *        6   7   8
 *           /   / \
 *          9  10   11
 *           \     /
 *           12   13
 * <p>
 * Return 9, which is the length of the path [12,9,7,4,2,5,8,11,13].
 * <p>
 * <b>Note:</b> The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    /**
     * Post-order traversal.
     *
     * O(n)
     *
     * @param root tree root
     * @return the diameter of a tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root)[1];
    }

    private int[] diameter(TreeNode root) {
        int[] pair = { 0, 0 };
        if (root == null) {
            return pair;
        }

        int[] leftResult = diameter(root.left);
        int[] rightResult = diameter(root.right);

        int height = Math.max(leftResult[0], rightResult[0]) + 1;
        int leftDiameter = leftResult[1];
        int rightDiameter = rightResult[1];
        int rootDiameter = leftResult[0] + rightResult[0];
        int finalDiameter = getMax(leftDiameter, rightDiameter, rootDiameter);

        pair[0] = height;
        pair[1] = finalDiameter;

        return pair;
    }

    private int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
