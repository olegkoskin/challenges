package week1.happy_number;

/**
 * Happy Number
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not
 * include 1. Those numbers for which this process ends in 1 are happy numbers.
 * <p>
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * Input: 110935384
 * Output: false
 * <p>
 * Input: 1111111
 * Output: true
 */
public class HappyNumberV3 {

    /**
     * Loop approach to simple unhappy number.
     *
     * @param n number
     * @return true if number is happy, otherwise false
     */
    public boolean isHappy(int n) {
        long newNum = n;
        while (true) {
            long sum = 0;

            while (newNum != 0) {
                int lastDigit = (int) newNum % 10;
                newNum /= 10;
                sum += lastDigit * lastDigit;
            }

            if (1 <= sum && sum <= 9) {
                return sum == 1 || sum == 7;
            } else {
                newNum = sum;
            }
        }
    }

}
