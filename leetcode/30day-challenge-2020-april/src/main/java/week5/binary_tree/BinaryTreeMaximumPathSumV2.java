package week5.binary_tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Binary Tree Maximum Path Sum.
 * <p>
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * Output: 6
 * <p>
 * Example 2:
 * <p>
 * Input: [-10,9,20,null,null,15,7]
 * <p>
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * Output: 42
 */
public class BinaryTreeMaximumPathSumV2 {

    /**
     * Iterative approach.
     * Traverse the nodes in post-order (the same as the order of topological sorting, actually) storing
     * the maximum root paths in a cache and updating the result value.
     *
     * @param root tree node
     * @return max path sum
     */
    public int maxPathSum(TreeNode root) {
        int result = Integer.MIN_VALUE;
        Map<TreeNode, Integer> maxRootPath = new HashMap<>(); // cache
        maxRootPath.put(null, 0); // for simplicity we want to handle null nodes
        for (TreeNode node : topSort(root)) {
            // as we process nodes in post-order their children are already cached
            int left = Math.max(maxRootPath.get(node.left), 0);
            int right = Math.max(maxRootPath.get(node.right), 0);
            maxRootPath.put(node, Math.max(left, right) + node.val);
            result = Math.max(left + right + node.val, result);
        }
        return result;
    }

    // just returns the nodes in post-order
    private Iterable<TreeNode> topSort(TreeNode root) {
        Deque<TreeNode> result = new LinkedList<>();
        if (root != null) {
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                result.push(curr);
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return result;
    }

}
