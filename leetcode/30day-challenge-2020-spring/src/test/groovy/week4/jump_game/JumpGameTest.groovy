package week4.jump_game

import spock.lang.Specification

class JumpGameTest extends Specification {

    def "Jump Game. Greedy approach."() {
        given:
            def jumpGame = new JumpGame()
        when:
            def canJump = jumpGame.canJump(nums)
        then:
            assert canJump == expected : ""
        where:
            nums || expected
            [2,3,1,1,4] as int[] || true
            [3,2,1,0,4] as int[] || false
    }

    def "Jump Game. DP approach."() {
        given:
            def jumpGame = new JumpGameV2()
        when:
            def canJump = jumpGame.canJump(nums)
        then:
            assert canJump == expected : ""
        where:
            nums || expected
            [2,3,1,1,4] as int[] || true
            [3,2,1,0,4] as int[] || false
    }

}
