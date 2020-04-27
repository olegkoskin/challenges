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
public class LongestCommonSubsequenceV2 {

    /**
     * Bottom-up approach using the 2-D array.
     *
     * time complexity - O(m*n)
     * space complexity - O(m*n)
     *
     * @param text1 text 1
     * @param text2 text 2
     * @return return the longest common subsequence or 0
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return lcs(text1.toCharArray(), text2.toCharArray(), text1.length(), text2.length());
    }

    private static int lcs(char[] x, char[] y, int m, int n) {
        int[][] memo = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (x[i - 1] == y[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        
        return memo[m][n];
    }

}
