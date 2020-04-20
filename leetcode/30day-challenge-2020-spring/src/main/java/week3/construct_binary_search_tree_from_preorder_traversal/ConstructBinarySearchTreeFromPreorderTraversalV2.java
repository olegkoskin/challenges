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
public class ConstructBinarySearchTreeFromPreorderTraversalV2 {

    private int i = 0;

    /**
     * Give the function a bound the maximum number it will handle.
     * The left recursion will take the elements smaller than {@code node.val}
     * The right recursion will take the remaining elements smaller than {@code bound}
     * <p>
     * O(n)
     *
     * <ul>
     *     <li>It is preorder traversal that is all the nodes in left tree is encountered before the nodes of right
     *     so we can generate the temp nodes as soon as we visit them.</li>
     *
     *     <li>We see the split point by sending a variable parent_value which denotes the value of the parent,
     *     once the value at index idx becomes greater than parent value we can retuen NULL, we make sure that all
     *     the nodes are less than the parent value are inserted in left subtree.</li>
     *
     *     <li>nce a node is less than parent value is found we make that node as left subtree and call the function
     *     recursively, and when the left recursion is over( when all values becomes greater than the current node's
     *     value) we will observe that the global idx will definately come to a point where the next node should be
     *     inserted to the right subtree</li>
     * </ul>
     *
     * @param preorder preorder traversal array
     * @return root of the binary search tree if array isn't empty, otherwise null
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, bound);

        return root;
    }

}


