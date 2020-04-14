package week2.perform_string_shifts

import spock.lang.Specification

class PerformStringShiftsTest extends Specification {

    def "Perform String Shifts."() {
        given:
            def performStringShifts = new PerformStringShifts()
        when:
            def str = performStringShifts.stringShift(s, shifts)
        then:
            str == expectedStr
        where:
            s         | shifts                               || expectedStr
            "abc"     | [[0,1],[1,2]] as int[][]             || "cab"
            "abcdefg" | [[1,1],[1,1],[0,2],[1,3]] as int[][] || "efgabcd"
            "wpdhhcj" | [[0,7],[1,7],[1,0],[1,3],[0,3],[0,6],[1,2]] as int[][] || "hcjwpdh"
            "yisxjwry" | [[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]] as int[][] || "yisxjwry"
    }

    def "Perform String Shifts. Brute force approach."() {
        given:
            def performStringShifts = new PerformStringShiftsV2()
        when:
            def str = performStringShifts.stringShift(s, shifts)
        then:
            str == expectedStr
        where:
            s         | shifts                               || expectedStr
            "abc"     | [[0,1],[1,2]] as int[][]             || "cab"
            "abcdefg" | [[1,1],[1,1],[0,2],[1,3]] as int[][] || "efgabcd"
            "wpdhhcj" | [[0,7],[1,7],[1,0],[1,3],[0,3],[0,6],[1,2]] as int[][] || "hcjwpdh"
            "yisxjwry" | [[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]] as int[][] || "yisxjwry"
    }
}
