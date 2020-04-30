package week1.happy_number;

import java.util.HashSet;
import java.util.Set;

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
public class HappyNumberV2 {

    /**
     * Set contain approach.
     *
     * @param n number
     * @return true if number is happy, otherwise false
     */
    public boolean isHappy(int n) {
        Set<Integer> uniqueNum = new HashSet<>();

        while (uniqueNum.add(n)) {
            int value = 0;
            while (n > 0) {
                value += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = value;
        }

        return n == 1;
    }

}
