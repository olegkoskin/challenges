package week3.construct_binary_search_tree_from_preorder_traversal

import spock.lang.Specification

class ConstructBinarySearchTreeFromPreorderTraversalTest extends Specification {

    def "Construct Binary Search Tree from Preorder Traversal. Recursion approach."() {
        given:
            def treeFromPreorderTraversal = new ConstructBinarySearchTreeFromPreorderTraversal()
        when:
            def root = treeFromPreorderTraversal.bstFromPreorder(preorder)
            def actual = treeToList(root)
        then:
            assert actual == expected :
                    "Preorder traversal $preorder should match to the binary search tree $expected, actual $actual"
        where:
            preorder || expected
            [8,5,1,7,10,12] as int[] || [8,5,10,1,7,null,12]
    }


    def "Construct Binary Search Tree from Preorder Traversal."() {
        given:
            def treeFromPreorderTraversal = new ConstructBinarySearchTreeFromPreorderTraversalV2()
        when:
            def root = treeFromPreorderTraversal.bstFromPreorder(preorder)
            def actual = treeToList(root)
        then:
            assert actual == expected :
                    "Preorder traversal $preorder should match to the binary search tree $expected, actual $actual"
        where:
            preorder || expected
            [8,5,1,7,10,12] as int[] || [8,5,10,1,7,null,12]
    }

    List treeToList(TreeNode root) {
        def list = []
        Queue<TreeNode> q = new LinkedList<>()
        if (root != null) {
            q.add(root)
        }
        while (!q.isEmpty()) {
            TreeNode node = q.remove()

            list << node?.val

            if (node != null) {
                def left = node.left
                def right = node.right
                if (left != null) {
                    q.add(left)
                    if (right == null) {
                        q.add(right)
                    }
                }
                if (right != null) {
                    if (left == null) {
                        q.add(left)
                    }
                    q.add(right)
                }
            }
        }
        return list
    }

}
