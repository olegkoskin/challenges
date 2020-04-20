package week3.construct_binary_search_tree_from_preorder_traversal;

/**
 * Construct Binary Search Tree from Preorder Traversal.
 * <p>
 * Return the root node of a binary search tree that matches the given preorder traversal.
 * <p>
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has
 * a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal
 * displays the value of the node first, then traverses node.left, then traverses node.right.)
 * <p>
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * <b>Note:</b>
 * <ul>
 *     <li>1 <= preorder.length <= 100</li>
 *     <li>The values of preorder are distinct.</li>
 * </ul>
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {

    /**
     * Recursion approach.
     * <p>
     * O(n^2)
     *
     * @param preorder preorder traversal array
     * @return root of the binary search tree if array isn't empty, otherwise null
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        int length = preorder.length;
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        for (int i = 1; i < length; i++) {
            processSubtree(root, preorder[i]);
        }

        return root;
    }

    private void processSubtree(TreeNode subtree, int val) {
        if (subtree.val > val) {
            TreeNode left = subtree.left;
            if (left == null) {
                subtree.left = new TreeNode(val);
            } else {
                processSubtree(left, val);
            }
        } else {
            TreeNode right = subtree.right;
            if (right == null) {
                subtree.right = new TreeNode(val);
            } else {
                processSubtree(right, val);
            }
        }
    }

}


