package week3.leftmost_column_with_at_least_a_one

import spock.lang.Specification

class LeftmostColumnWithAtLeastAOneTest extends Specification {

    def "Leftmost Column with at Least a One. Binary search."() {
        given:
            def atLeastAOne = new LeftmostColumnWithAtLeastAOne();
        when:
            def index = atLeastAOne.leftMostColumnWithOne(binaryMatrix)
        then:
            assert index == expected : "Binary matrix should have leftmost column at $expected, actual $index. Matrix ${displayMatrix(binaryMatrix)}"
        where:
            binaryMatrix || expected
            new TestBinaryMatrix([[0,0],[1,1]] as int[][]) || 0
            new TestBinaryMatrix([[0,0],[0,1]] as int[][]) || 1
            new TestBinaryMatrix([[0,0],[0,0]] as int[][]) || -1
            new TestBinaryMatrix([[0,0,0,1],[0,0,1,1],[0,1,1,1]] as int[][]) || 1
    }

    def "Leftmost Column with at Least a One. Brute force approach."() {
        given:
            def atLeastAOne = new LeftmostColumnWithAtLeastAOneV2();
        when:
            def index = atLeastAOne.leftMostColumnWithOne(binaryMatrix)
        then:
            assert index == expected : "Binary matrix should have leftmost column at $expected, actual $index. Matrix ${displayMatrix(binaryMatrix)}"
        where:
            binaryMatrix || expected
            new TestBinaryMatrix([[0,0],[1,1]] as int[][]) || 0
            new TestBinaryMatrix([[0,0],[0,1]] as int[][]) || 1
            new TestBinaryMatrix([[0,0],[0,0]] as int[][]) || -1
            new TestBinaryMatrix([[0,0,0,1],[0,0,1,1],[0,1,1,1]] as int[][]) || 1
    }

    def "Leftmost Column with at Least a One. Top right corner to lef and down approach."() {
        given:
            def atLeastAOne = new LeftmostColumnWithAtLeastAOneV3();
        when:
            def index = atLeastAOne.leftMostColumnWithOne(binaryMatrix)
        then:
            assert index == expected : "Binary matrix should have leftmost column at $expected, actual $index. Matrix ${displayMatrix(binaryMatrix)}"
        where:
            binaryMatrix || expected
            new TestBinaryMatrix([[0,0],[1,1]] as int[][]) || 0
            new TestBinaryMatrix([[0,0],[0,1]] as int[][]) || 1
            new TestBinaryMatrix([[0,0],[0,0]] as int[][]) || -1
            new TestBinaryMatrix([[0,0,0,1],[0,0,1,1],[0,1,1,1]] as int[][]) || 1
    }

    String displayMatrix(TestBinaryMatrix matrix) {
        def str = "\n["
        for (int i = 0; i < matrix.mat.length; i++) {
            str <<= Arrays.toString(matrix.mat[i])
            if (i < matrix.mat.length - 1) {
                str <<= ",\n "
            }
        }
        return str << "]"
    }
}
