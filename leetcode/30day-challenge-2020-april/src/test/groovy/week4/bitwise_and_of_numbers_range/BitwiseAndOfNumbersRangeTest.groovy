package week4.bitwise_and_of_numbers_range

import spock.lang.Specification

class BitwiseAndOfNumbersRangeTest extends Specification {

    def "Bitwise AND of Numbers Range"() {
        given:
            def bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRange()
        when:
            def AndOfAllnumbers = bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n)
        then:
            assert AndOfAllnumbers == expected : ""
        where:
            m | n || expected
            5 | 7 || 4
            0 | 1 || 0
            0 | 2147483647 || 0
            20000 | 2147483647 || 0
    }

    def "Bitwise AND of Numbers Range. Brute force"() {
        given:
            def bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRangeV2()
        when:
            def AndOfAllnumbers = bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n)
        then:
            assert AndOfAllnumbers == expected : ""
        where:
            m | n || expected
            5 | 7 || 4
            0 | 1 || 0
            0 | 2147483647 || 0
            //20000 | 2147483647 || 0
    }

    def "Bitwise AND of Numbers Range. Consecutive numbers"() {
        given:
            def bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRangeV3()
        when:
            def AndOfAllnumbers = bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n)
        then:
            assert AndOfAllnumbers == expected : ""
        where:
            m | n || expected
            5 | 7 || 4
            0 | 1 || 0
            0 | 2147483647 || 0
            20000 | 2147483647 || 0
    }

    def "Bitwise AND of Numbers Range. Most Significant Bit."() {
        given:
            def bitwiseAndOfNumbersRange = new BitwiseAndOfNumbersRangeV4()
        when:
            def AndOfAllnumbers = bitwiseAndOfNumbersRange.rangeBitwiseAnd(m, n)
        then:
            assert AndOfAllnumbers == expected : ""
        where:
            m | n || expected
            5 | 7 || 4
            0 | 1 || 0
            0 | 2147483647 || 0
            20000 | 2147483647 || 0
    }

}
