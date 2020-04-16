package week3.valid_parenthesis_string;

/**
 * Valid Parenthesis String.
 * <p>
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * <ol>
 *     <li>Any left parenthesis '(' must have a corresponding right parenthesis ')'.</li>
 *     <li>Any right parenthesis ')' must have a corresponding left parenthesis '('.</li>
 *     <li>Left parenthesis '(' must go before the corresponding right parenthesis ')'.</li>
 *     <li>'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.</li>
 *     <li>An empty string is also valid.</li>
 * </ol>
 * <p>
 * Example 1:
 * Input: "()"
 * Output: True
 * <p>
 * Example 2:
 * Input: "(*)"
 * Output: True
 * <p>
 * Example 3:
 * Input: "(*))"
 * Output: True
 *
 * <b>Note:</b> The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {

    /**
     * We count the number of ')' we are waiting for,
     * and it's equal to the number of open parenthesis.
     * This number will be in a range and we count it as [cmin, cmax]
     *
     * cmax counts the maximum open parenthesis,
     * which means the maximum number of unbalanced '(' that COULD be paired.
     * cmin counts the minimum open parenthesis,
     * which means the number of unbalanced '(' that MUST be paired.
     *
     * @param s string
     * @return true if parenthesis are balanced
     */
    public boolean checkValidString(String s) {
        int cmin = 0;
        int cmax = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin = Math.max(cmin - 1, 0);
            } else {
                cmax++;
                cmin = Math.max(cmin - 1, 0);
            }
            if (cmax < 0) return false;
        }
        return cmin == 0;
    }

}
