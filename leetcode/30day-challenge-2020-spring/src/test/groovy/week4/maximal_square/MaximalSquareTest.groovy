package week4.maximal_square

import spock.lang.Specification

class MaximalSquareTest extends Specification {

    def "Maximal Square. DP approach"() {
        given:
            def ms = new MaximalSquare()
        when:
            def largestSquareArea = ms.maximalSquare(matrix)
        then:
            assert largestSquareArea == expected : ""
        where:
            matrix || expected
            [['1', '0', '1', '0', '0'],
             ['1', '0', '1', '1', '1'],
             ['1', '1', '1', '1', '1'],
             ['1', '0', '0', '1', '0']] as char[][] || 4
            [["0"]] as char[][] || 0
            [['1','0'],
             ['1','0']] as char[][] || 1
    }

    def "Maximal Square. Recursion with memoization approach."() {
        given:
            def ms = new MaximalSquareV2()
        when:
            def largestSquareArea = ms.maximalSquare(matrix)
        then:
            assert largestSquareArea == expected : ""
        where:
            matrix || expected
            [['1', '0', '1', '0', '0'],
             ['1', '0', '1', '1', '1'],
             ['1', '1', '1', '1', '1'],
             ['1', '0', '0', '1', '0']] as char[][] || 4
            [["0"]] as char[][] || 0
            [['1','0'],
             ['1','0']] as char[][] || 1
    }

    def "Maximal Square. Recursion approach."() {
        given:
            def ms = new MaximalSquareV3()
        when:
            def largestSquareArea = ms.maximalSquare(matrix)
        then:
            assert largestSquareArea == expected : ""
        where:
            matrix || expected
            [['1', '0', '1', '0', '0'],
             ['1', '0', '1', '1', '1'],
             ['1', '1', '1', '1', '1'],
             ['1', '0', '0', '1', '0']] as char[][] || 4
            [["0"]] as char[][] || 0
            [['1','0'],
             ['1','0']] as char[][] || 1
    }

}
