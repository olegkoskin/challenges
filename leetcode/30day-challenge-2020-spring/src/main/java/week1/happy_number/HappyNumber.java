package week1.happy_number;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Happy Number
 *
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
public class HappyNumber {

    private static final Set<Integer> UNHAPPY_NUMBERS = Set.of(2, 3, 4, 5, 6, 8, 9);

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        assert happyNumber.isHappy(19);
        assert !happyNumber.isHappy(110935384);
        assert happyNumber.isHappy(7);
        assert happyNumber.isHappy(1111111);
    }

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (UNHAPPY_NUMBERS.contains(n)) {
            return false;
        }

        int newNum = n;
        List<Integer> digits = getDigits(newNum);
        newNum = calculateNewNum(digits);

        return newNum == 1 || isHappy(newNum);
    }

    private int calculateNewNum(List<Integer> digits) {
        int newNum = 0;
        for (int num : digits) {
            newNum += num * num;
        }
        return newNum;
    }

    private List<Integer> getDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

}
