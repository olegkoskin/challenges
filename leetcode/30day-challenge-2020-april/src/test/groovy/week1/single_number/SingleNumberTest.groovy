package week1.single_number

import spock.lang.Specification

class SingleNumberTest extends Specification {
    def "SingleNumber. Exclusive OR"() {
        given:
            def singleNumber = new SingleNumber()
        when:
            def num = singleNumber.singleNumber(nums)
        then:
            num == expectedNum
        where:
            expectedNum || nums
            1 || [2, 2, 1] as int[]
            4 || [4, 1, 2, 1, 2] as int[]
    }

    def "SingleNumber. Map counter"() {
        given:
            def singleNumber = new SingleNumberV2()
        when:
            def num = singleNumber.singleNumber(nums)
        then:
            num == expectedNum
        where:
            expectedNum || nums
            1 || [2, 2, 1] as int[]
            4 || [4, 1, 2, 1, 2] as int[]
    }

    def "SingleNumber. Map contain"() {
        given:
            def singleNumber = new SingleNumberV3()
        when:
            def num = singleNumber.singleNumber(nums)
        then:
            num == expectedNum
        where:
            expectedNum || nums
            1 || [2, 2, 1] as int[]
            4 || [4, 1, 2, 1, 2] as int[]
    }
}
