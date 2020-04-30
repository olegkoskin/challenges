package week4.longest_common_subsequence

import spock.lang.Specification

class LongestCommonSubsequenceTest extends Specification {

    def "Longest Common Subsequence. Bottom-up approach using the 1-D array."() {
        given:
            def lcs = new LongestCommonSubsequence()
        when:
            def longestCommonSubsequence = lcs.longestCommonSubsequence(text1, text2)
        then:
            assert longestCommonSubsequence == expected : "'$text1' and '$text2' have a longest common subsequence with length $expected, actual $longestCommonSubsequence"
        where:
            text1   | text2 || expected
            "abcde" | "ace" || 3
            "abc"   | "abc" || 3
            "abc"   | "def" || 0
    }

    def "Longest Common Subsequence. Bottom-up approach using the 2-D array."() {
        given:
            def lcs = new LongestCommonSubsequenceV2()
        when:
            def longestCommonSubsequence = lcs.longestCommonSubsequence(text1, text2)
        then:
            assert longestCommonSubsequence == expected : "'$text1' and '$text2' have a longest common subsequence with length $expected, actual $longestCommonSubsequence"
        where:
            text1   | text2 || expected
            "abcde" | "ace" || 3
            "abc"   | "abc" || 3
            "abc"   | "def" || 0
    }

    def "Longest Common Subsequence. Recursion with memorization or top-down approach"() {
        given:
            def lcs = new LongestCommonSubsequenceV3()
        when:
            def longestCommonSubsequence = lcs.longestCommonSubsequence(text1, text2)
        then:
            assert longestCommonSubsequence == expected : "'$text1' and '$text2' have a longest common subsequence with length $expected, actual $longestCommonSubsequence"
        where:
            text1   | text2 || expected
            "abcde" | "ace" || 3
            "abc"   | "abc" || 3
            "abc"   | "def" || 0
    }

    def "Longest Common Subsequence. Recursion approach."() {
        given:
            def lcs = new LongestCommonSubsequenceV4()
        when:
            def longestCommonSubsequence = lcs.longestCommonSubsequence(text1, text2)
        then:
            assert longestCommonSubsequence == expected : "'$text1' and '$text2' have a longest common subsequence with length $expected, actual $longestCommonSubsequence"
        where:
            text1   | text2 || expected
            "abcde" | "ace" || 3
            "abc"   | "abc" || 3
            "abc"   | "def" || 0
    }

}
