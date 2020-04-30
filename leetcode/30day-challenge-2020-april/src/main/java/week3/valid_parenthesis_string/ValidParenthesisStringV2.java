package week3.valid_parenthesis_string;

import java.util.Deque;
import java.util.LinkedList;

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
public class ValidParenthesisStringV2 {

    /**
     * Two stack approach.
     *
     * @param s string
     * @return true if parenthesis are balanced
     */
    public boolean checkValidString(String s) {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> start = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                left.push(i);
            } else if (ch == '*') {
                start.push(i);
            } else { // ch == ')'
                if (left.isEmpty() && start.isEmpty()) {
                    return false;
                }
                if (!left.isEmpty()) {
                    left.pop();
                } else {
                    start.pop();
                }
            }
        }
        while (!left.isEmpty() && !start.isEmpty()) {
            if (left.pop() > start.pop()) {
                return false;
            }
        }
        return left.isEmpty();
    }

}
