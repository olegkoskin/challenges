package week2.backspace_string_compare;

/**
 * Backspace String Compare.
 * <p>
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * <p>
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * <p>
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * <p>
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * <p>
 * Example 4:
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
public class BackspaceStringCompareV2 {

    /**
     * Normalize string and reverse string comparing.
     *
     * @param S 1st string
     * @param T 2nd string
     * @return true if the strings are equal using backspace logic
     */
    public boolean backspaceCompare(String S, String T) {
        return normalize(S).equals(normalize(T));
    }

    private String normalize(String str) {
        int length = str.length();
        StringBuilder b = new StringBuilder(length);
        int backspaceCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                b.append(ch);
            }
        }
        return b.toString();
    }

}
