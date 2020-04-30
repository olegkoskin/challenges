package week2.last_stone_weight

import spock.lang.Specification

class LastStoneWeightTest extends Specification {

    def "Last Stone Weight. Sorting approach"() {
        given:
            def lastStoneWeight = new LastStoneWeight()
        when:
            def weight = lastStoneWeight.lastStoneWeight(stones)
        then:
            weight == expectedWeight
        where:
            stones || expectedWeight
            [2,7,4,1,8,1] as int[] || 1
            [1,1,1,1,1,1000] as int[] || 995
    }

    def "Last Stone Weight. Recursion approach."() {
        given:
            def lastStoneWeight = new LastStoneWeightV2()
        when:
            def weight = lastStoneWeight.lastStoneWeight(stones)
        then:
            weight == expectedWeight
        where:
            stones || expectedWeight
            [2,7,4,1,8,1] as int[] || 1
            [1,1,1,1,1,1000] as int[] || 995
    }

    def "Last Stone Weight. PriorityQueue approach."() {
        given:
            def lastStoneWeight = new LastStoneWeightV3()
        when:
            def weight = lastStoneWeight.lastStoneWeight(stones)
        then:
            weight == expectedWeight
        where:
            stones || expectedWeight
            [2,7,4,1,8,1] as int[] || 1
            [1,1,1,1,1,1000] as int[] || 995
    }

}
