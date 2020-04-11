package week2.diameter_of_binary_tree

import spock.lang.Specification

class DiameterOfBinaryTreeTest extends Specification {

    def "Diameter of Binary Tree. Post-order traversal."() {
        given:
            def diameterOfBinaryTree = new DiameterOfBinaryTree()
        when:
            def diameter = diameterOfBinaryTree.diameterOfBinaryTree(root)
        then:
            diameter == expectedDiameter
        where:
            root         || expectedDiameter
            buildTree1() || 3
            buildTree2() || 8
    }

    def "Diameter of Binary Tree. Maximum node paths."() {
        given:
            def diameterOfBinaryTree = new DiameterOfBinaryTreeV2()
        when:
            def diameter = diameterOfBinaryTree.diameterOfBinaryTree(root)
        then:
            diameter == expectedDiameter
        where:
            root         || expectedDiameter
            buildTree1() || 3
            buildTree2() || 8
    }

    def buildTree1() {
        def root = new TreeNode(1)
        def node2 = new TreeNode(2)
        def node3 = new TreeNode(3)
        def node4 = new TreeNode(4)
        def node5 = new TreeNode(5)

        root.left = node2
        root.right = node3

        node2.left = node4
        node2.right = node5

        return root
    }

    def buildTree2() {
        def root = new TreeNode(1)
        def node2 = new TreeNode(2)
        def node3 = new TreeNode(3)
        def node4 = new TreeNode(4)
        def node5 = new TreeNode(5)
        def node6 = new TreeNode(6)
        def node7 = new TreeNode(7)
        def node8 = new TreeNode(8)
        def node9 = new TreeNode(9)
        def node10 = new TreeNode(10)
        def node11 = new TreeNode(11)
        def node12 = new TreeNode(12)
        def node13 = new TreeNode(13)

        root.left = node2
        root.right = node3

        node2.left = node4
        node2.right = node5

        node4.left = node6
        node4.right = node7

        node5.right = node8

        node7.left = node9

        node8.left = node10
        node8.right = node11

        node9.right = node12

        node11.left = node13

        return root
    }

}
