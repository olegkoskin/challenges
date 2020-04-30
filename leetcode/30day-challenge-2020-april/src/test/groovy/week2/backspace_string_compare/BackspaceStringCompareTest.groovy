package week2.backspace_string_compare


import spock.lang.Specification

class BackspaceStringCompareTest extends Specification {

    def "Backspace String Compare."() {
        given:
            def backspaceCompare = new BackspaceStringCompare()
        when:
            def isEquals = backspaceCompare.backspaceCompare(s,t)
        then:
            isEquals == expected
        where:
            s      | t      || expected
            "ab#c" | "ad#c" || true
            "ab##" | "c#d#" || true
            "a##c" | "#a#c" || true
            "a#c"  | "b"    || false
    }

    def "Backspace String Compare. Normalize strings"() {
        given:
            def backspaceCompare = new BackspaceStringCompareV2()
        when:
            def isEquals = backspaceCompare.backspaceCompare(s,t)
        then:
            isEquals == expected
        where:
            s      | t      || expected
            "ab#c" | "ad#c" || true
            "ab##" | "c#d#" || true
            "a##c" | "#a#c" || true
            "a#c"  | "b"    || false
    }

}
