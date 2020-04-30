package week3.valid_parenthesis_string

import spock.lang.Specification

class ValidParenthesisStringTest extends Specification {

    def "Valid Parenthesis String."() {
        given:
            def validParenthesisString = new ValidParenthesisString()
        when:
            def valid = validParenthesisString.checkValidString(s)
        then:
            valid == expected
        where:
            s      || expected
            "()"   || true
            "(*)"  || true
            "(*))" || true
    }

    def "Valid Parenthesis String. Two stacks"() {
        given:
            def validParenthesisString = new ValidParenthesisStringV2()
        when:
            def valid = validParenthesisString.checkValidString(s)
        then:
            valid == expected
        where:
            s      || expected
            "()"   || true
            "(*)"  || true
            "(*))" || true
    }

}
