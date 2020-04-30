package week5.binary_tree

import spock.lang.Specification

class BinaryTreeMaximumPathSumTest extends Specification {

    def "Binary Tree Maximum Path Sum. Recursion approach."() {
        given:
            def treeMaximumPathSum = new BinaryTreeMaximumPathSum()
        when:
            def maxPathSum = treeMaximumPathSum.maxPathSum(root)
        then:
            assert maxPathSum == expected : ""
        where:
        root || expected
            buildTree1() || 6
            buildTree2() || 42
            buildTree3() || -3
            buildTree4() || 3
    }

    def "Binary Tree Maximum Path Sum. Iterative approach."() {
        given:
            def treeMaximumPathSum = new BinaryTreeMaximumPathSumV2()
        when:
            def maxPathSum = treeMaximumPathSum.maxPathSum(root)
        then:
            assert maxPathSum == expected : ""
        where:
        root || expected
            buildTree1() || 6
            buildTree2() || 42
            buildTree3() || -3
            buildTree4() || 3
    }

    TreeNode buildTree1() {
        def left = new TreeNode(2)
        def right = new TreeNode(3)

        return new TreeNode(1, left, right)
    }

    TreeNode buildTree2() {
        return new TreeNode(-10, new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)))
    }

    TreeNode buildTree3() {
        return new TreeNode(-3)
    }

    TreeNode buildTree4() {
        return new TreeNode(1,
                new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)),
                new TreeNode(-3, new TreeNode(-2), null));
    }
}
