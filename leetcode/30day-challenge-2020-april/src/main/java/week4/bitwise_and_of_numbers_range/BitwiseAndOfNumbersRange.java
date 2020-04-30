package week4.bitwise_and_of_numbers_range;

/**
 * Bitwise AND of Numbers Range.
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 * Input: [5,7]
 * Output: 4
 *
 * Example 2:
 * Input: [0,1]
 * Output: 0
 */
public class BitwiseAndOfNumbersRange {

    /**
     * Right shift approach.
     *
     * @param m lower bound
     * @param n upper bound
     * @return the bitwise AND of all numbers in this range, inclusive
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0; // count means we have how many bits are 0 on the right
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count; // Result is left shift of low count times.
    }

}
