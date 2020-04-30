package week2.perform_string_shifts;

/**
 * Perform String Shifts.
 * <p>
 * You are given a string s containing lowercase English letters, and a matrix shift,
 * where shift[i] = [direction, amount]:
 * <ul>
 *     <li>direction can be 0 (for left shift) or 1 (for right shift).</li>
 *     <li>amount is the amount by which string s is to be shifted.</li>
 *     <li>A left shift by 1 means remove the first character of s and append it to the end.</li>
 *     <li>Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.</li>
 * </ul>
 * Return the final string after all operations.
 * <p>
 * Example 1:
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * <p>
 * Example 2:
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 * <p>
 * Constraints:
 * <ul>
 *     <li>1 <= s.length <= 100</li>
 *     <li>s only contains lower case English letters.</li>
 *     <li>1 <= shift.length <= 100</li>
 *     <li>shift[i].length == 2</li>
 *     <li>0 <= shift[i][0] <= 1</li>
 *     <li>0 <= shift[i][1] <= 100</li>
 * </ul>
 * <p>
 * Hint #1: Intuitively performing all shift operations is acceptable due to the constraints.
 * Hint #2: You may notice that left shift cancels the right shift, so count the total left shift times (may be negative
 * if the final result is right shift), and perform it once.
 */
public class PerformStringShifts {

    /**
     * Calculate total shifting.
     *
     * @param s     string
     * @param shift shifts
     * @return the string after all operation
     */
    public String stringShift(String s, int[][] shift) {
        int direction = 0;
        int amount = 0;
        for (int[] ints : shift) {
            if (ints[0] == 0) {
                amount -= ints[1];
            } else {
                amount += ints[1];
            }
            direction = Integer.compare(amount, 0);
        }
        if (direction == -1) {
            amount = -amount % s.length();
            s = s.substring(amount) + s.substring(0, amount);
        } else if (direction == 1) {
            int index = s.length() - (amount % s.length());
            s = s.substring(index) + s.substring(0, index);
        }

        return s;
    }

}
