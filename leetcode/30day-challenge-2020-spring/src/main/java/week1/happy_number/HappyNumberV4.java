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
public class HappyNumberV4 {

    public static void main(String[] args) {
        HappyNumberV4 happyNumber = new HappyNumberV4();

        assert happyNumber.isHappy(19);
        assert !happyNumber.isHappy(110935384);
        assert happyNumber.isHappy(7);
        assert happyNumber.isHappy(1111111);
    }

    // "Floyd's cycle-finding algorithm" also known as "Tortoise and the Hare algorithm".
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = compute(slow); // slow computes only once
            fast = compute(compute(fast)); // fast computes 2 times

            // if we found 1 then happy indeed !!!
            if (slow == 1) {
                return true;
            }
        } while (slow != fast); // else at some point they will meet in the cycle

        return false; // it'slow a cycle , not happy at all !!!
    }

    public int compute(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }

}
