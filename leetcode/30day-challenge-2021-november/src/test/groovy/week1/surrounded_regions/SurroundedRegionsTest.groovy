package week1.surrounded_regions

import groovy.test.GroovyAssert
import spock.lang.Specification

class SurroundedRegionsTest extends Specification {

    def "Surrounded Regions. Depth-first search"() {
        when:
            new SurroundedRegions().solve(board)
        then:
            GroovyAssert.assertEquals(extectedBoard,  board)
        where:
            board || extectedBoard
            [["X","X","X","X"],
             ["X","O","O","X"],
             ["X","X","O","X"],
             ["X","O","X","X"]] as char[][] || [["X","X","X","X"],
                                                ["X","X","X","X"],
                                                ["X","X","X","X"],
                                                ["X","O","X","X"]]  as char[][]
            [["X","X","X","X"],
             ["X","X","O","X"],
             ["X","O","X","X"],
             ["X","O","X","X"]] as char[][] || [["X","X","X","X"],
                                                ["X","X","X","X"],
                                                ["X","O","X","X"],
                                                ["X","O","X","X"]]  as char[][]
    }

}
