package week1.move_zeroes

import spock.lang.Specification

class MoveZeroesTest extends Specification {

    def "MoveZeroes. A two-pointer approach"() {
        given:
            def moveZeroes = new MoveZeroes();
        when:
            moveZeroes.moveZeroes(nums)
        then:
            nums == expectedNums
        where:
            nums || expectedNums
            [0,1,0,3,12] as int[] || [1,3,12,0,0] as int[]
    }

    def "MoveZeroes. A two loop approach"() {
        given:
            def moveZeroes = new MoveZeroesV2();
        when:
            moveZeroes.moveZeroes(nums)
        then:
            nums == expectedNums
        where:
            nums || expectedNums
            [0,1,0,3,12] as int[] || [1,3,12,0,0] as int[]
    }

    def "MoveZeroes. A snowball approach"() {
        given:
            def moveZeroes = new MoveZeroesV3();
        when:
            moveZeroes.moveZeroes(nums)
        then:
            nums == expectedNums
        where:
            nums || expectedNums
            [0,1,0,3,12] as int[] || [1,3,12,0,0] as int[]
    }

}
