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
public class BitwiseAndOfNumbersRangeV3 {

    /**
     * Bitwise AND consecutive numbers.
     *
     * @param m lower bound
     * @param n upper bound
     * @return the bitwise AND of all numbers in this range, inclusive
     */
    public int rangeBitwiseAnd(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return m & n;
    }

}
