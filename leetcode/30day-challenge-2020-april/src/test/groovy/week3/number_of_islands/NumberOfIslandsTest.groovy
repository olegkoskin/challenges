package week3.number_of_islands

import spock.lang.Specification

class NumberOfIslandsTest extends Specification {

    def "Number of Islands."() {
        given:
            def numberOfIslands = new NumberOfIslands()
        when:
            def numIslands = numberOfIslands.numIslands(grid)
        then:
            assert numIslands == expected : "Should find $expected islands"
        where:
            grid || expected
            [['1', '1', '1', '1', '0'],
             ['1', '1', '0', '1', '0'],
             ['1', '1', '0', '0', '0'],
             ['0', '0', '0', '0', '0']] as char[][] || 1
            [['1', '1', '0', '0', '0'],
             ['1', '1', '0', '0', '0'],
             ['0', '0', '1', '0', '0'],
             ['0', '0', '0', '1', '1']] as char[][] || 3
    }
}
