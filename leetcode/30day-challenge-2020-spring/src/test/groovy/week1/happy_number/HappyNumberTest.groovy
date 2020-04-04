package week1.happy_number

import spock.lang.Specification

class HappyNumberTest extends Specification {

    def "HappyNumber. Recursion approach to simple unhappy number."() {
        given:
            def happyNumber = new HappyNumber()
        when:
            def isHappy = happyNumber.isHappy(num)
        then:
            isHappy == expectedHappy
        where:
            expectedHappy || num
            true  || 19
            false || 110935384
            true  || 7
            true  || 1111111
    }

    def "HappyNumber. Set contain."() {
        given:
            def happyNumber = new HappyNumberV2()
        when:
            def isHappy = happyNumber.isHappy(num)
        then:
            isHappy == expectedHappy
        where:
            expectedHappy || num
            true  || 19
            false || 110935384
            true  || 7
            true  || 1111111
    }

    def "HappyNumber. Loop approach to simple unhappy number."() {
        given:
            def happyNumber = new HappyNumberV3()
        when:
            def isHappy = happyNumber.isHappy(num)
        then:
            isHappy == expectedHappy
        where:
            expectedHappy || num
            true  || 19
            false || 110935384
            true  || 7
            true  || 1111111
    }

    def "HappyNumber. Floyd's cycle-finding or 'Tortoise and the Hare' algorithm."() {
        given:
            def happyNumber = new HappyNumberV4()
        when:
            def isHappy = happyNumber.isHappy(num)
        then:
            isHappy == expectedHappy
        where:
            expectedHappy || num
            true  || 19
            false || 110935384
            true  || 7
            true  || 1111111
    }
}
