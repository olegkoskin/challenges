package week2.backspace_string_compare;

/**
 * Backspace String Compare.
 * <p>
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * <p>
 * <b>Example 1:</b>
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * <p>
 * <b>Example 2:</b>
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * <p>
 * <b>Example 3:</b>
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * <p>
 * <b>Example 4:</b>
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * <p>
 * Note:
 * <ol>
 *     <li>1 <= S.length <= 200</li>
 *     <li>1 <= T.length <= 200</li>
 *     <li>S and T only contain lowercase letters and '#' characters.</li>
 * </ol>
 * <p>
 * Follow up:
 * <ul>
 *     <li>Can you solve it in O(N) time and O(1) space?</li>
 * </ul>
 */
public class BackspaceStringCompare {

    /**
     * Comparing string from the end without creating string.
     * Read next letter from end to start. If we meet #, we increase the number we need to step back, until back = 0
     *
     * @param S 1st string
     * @param T 2nd string
     * @return true if the strings are equal using backspace logic
     */
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int countS = 0;
        int countT = 0;

        while (i >= 0 || j >= 0) { //note, we keep looking as long as i or j has elements
            while (i >= 0 && (countS > 0 || S.charAt(i) == '#'))
                countS += S.charAt(i--) == '#' ? 1 : -1;

            while (j >= 0 && (countT > 0 || T.charAt(j) == '#'))
                countT += T.charAt(j--) == '#' ? 1 : -1;

            if (i < 0 || j < 0)
                return (i == j);

            if (S.charAt(i--) != T.charAt(j--))
                return false;
        }

        return (i == j);
    }

}
