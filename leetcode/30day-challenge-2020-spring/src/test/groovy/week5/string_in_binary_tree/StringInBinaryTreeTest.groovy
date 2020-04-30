package week5.string_in_binary_tree

import spock.lang.Specification

class StringInBinaryTreeTest extends Specification {

    def "String in Binary tree. DFS"() {
        given:
            def binaryTree = new StringInBinaryTree();
        when:
            def validSequence = binaryTree.isValidSequence(root, arr)
        then:
            assert validSequence == expected : "Should be $expected. Sequence $arr"
        where:
            root | arr || expected
            buildTree1() | [0,1,0,1] as int[] || true
            buildTree1() | [0,0,1] as int[] || false
            buildTree1() | [0,1,1] as int[] || false
            buildTree2() | [4,2,7,4] as int[] || true
    }

    def "String in Binary tree. BFS"() {
        given:
            def binaryTree = new StringInBinaryTreeV2();
        when:
            def validSequence = binaryTree.isValidSequence(root, arr)
        then:
            assert validSequence == expected : "Should be $expected. Sequence $arr"
        where:
            root | arr || expected
            buildTree1() | [0,1,0,1] as int[] || true
            buildTree1() | [0,0,1] as int[] || false
            buildTree1() | [0,1,1] as int[] || false
            buildTree2() | [4,2,7,4] as int[] || true
    }

    TreeNode buildTree1() {
        return new TreeNode(0,
                new TreeNode(1,
                        new TreeNode(0, null, new TreeNode(1)),
                        new TreeNode(1, new TreeNode(0), new TreeNode(0))),
                new TreeNode(0, new TreeNode(0), null))
    }

    TreeNode buildTree2() {
        [4,null,2,7,5,3,4,4]
        return new TreeNode(4,
                null,
                new TreeNode(2,
                        new TreeNode(7, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(5, new TreeNode(4), null)))
    }

    TreeNode buildTree3() {
        return new TreeNode()
    }

}
