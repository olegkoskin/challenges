package week4.longest_common_subsequence;

/**
 * Longest Common Subsequence.
 * <p>
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * <p>
 * A subsequence of a string is a new string generated from the original string with some characters(can be none)
 * deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 * <p>
 * If there is no common subsequence, return 0.
 * <p>
 * Example 1:
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * <p>
 * Example 2:
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * <p>
 * Example 3:
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li> 1 <= text1.length <= 1000</li>
 *     <li> 1 <= text2.length <= 1000</li>
 *     <li> The input strings consist of lowercase English characters only.</li>
 * </ul>
 *
 * <b>Hint #1:</b> Try dynamic programming. DP[i][j] represents the longest common subsequence of text1[0 ... i] & text2[0 ... j].
 * <b>Hint #2:</b> DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j] DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise
 */
public class LongestCommonSubsequenceV3 {

    /**
     * Recursion with memorization or top-down approach.
     *
     * time complexity - O(m*n)
     * space complexity - O(m*n)
     *
     * @param text1 text 1
     * @param text2 text 2
     * @return return the longest common subsequence or 0
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int lengthX = text1.length();
        int lengthY = text2.length();
        Integer[][] dp = new Integer[lengthX + 1][lengthY + 1];
        return lcs(text1.toCharArray(), text2.toCharArray(), lengthX, lengthY, dp);
    }

    private static int lcs(char[] x, char[] y, int i, int j, Integer[][] dp) {
        if (i <= 0 || j <= 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (x[i - 1] == y[j - 1]) {
            return 1 + lcs(x, y, i - 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(lcs(x, y, i, j - 1, dp), lcs(x, y, i - 1, j, dp));
            return dp[i][j] ;
        }
    }

}
