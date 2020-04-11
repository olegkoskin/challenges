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
public class DiameterOfBinaryTreeV2 {

    /**
     * Maximum node paths.
     *
     * The diameter of a tree T is the largest of the following quantities:
     * 1) the diameter of T’s left subtree
     * 2) the diameter of T’s right subtree
     * 3) the longest path between leaves that goes through the root of T (this can be computed from the heights of
     * the subtrees of T)
     *
     * O(n^2)
     *
     * @param root tree root
     * @return the diameter of a tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // tree is empty
        if (root == null) {
            return 0;
        }

        // the left and right subtrees heights
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        // the left and right subtrees diameters
        int lDiameter = diameterOfBinaryTree(root.left);
        int rDiameter = diameterOfBinaryTree(root.right);

        // max of following:
        // 1) Diameter of left subtree
        // 2) Diameter of right subtree
        // 3) Height of left subtree + height of right subtree (+1 if we need to know number of nodes, not the edges)
        return Math.max(lHeight + rHeight, Math.max(lDiameter, rDiameter));
    }

    /**
     * Height is the number f nodes along the longest path from the root node down to the farthest leaf node.
     *
     * @param root tree root
     * @return height of a tree
     */
    private static int height(TreeNode root) {
        // tree is empty
        if (root == null) {
            return 0;
        }

        // tree isn't empty, so height = 1 + max of left subtree and right subtree heights
        return 1 + Math.max(height(root.left), height(root.right));
    }

}
