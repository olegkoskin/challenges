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
public class BitwiseAndOfNumbersRangeV4 {

    /**
     * Most Significant Bit approach.
     *
     * @param m lower bound
     * @param n upper bound
     * @return the bitwise AND of all numbers in this range, inclusive
     */
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0; // Initialize result

        while (m > 0 && n > 0) {

            // Find positions of MSB in m and n
            int msbP1 = msbPos(m);
            int msbP2 = msbPos(n);

            // If positions are not same, return
            if (msbP1 != msbP2)
                break;

            // Add 2^msbP1 to result
            int msbVal = (1 << msbP1);
            res = res + msbVal;

            // subtract 2^msbP1 from x and y.
            m = m - msbVal;
            n = n - msbVal;
        }

        return res;
    }

    private static int msbPos(int n)
    {
        int msbP = -1;
        while (n > 0) {
            n = n >> 1;
            msbP++;
        }

        return msbP;
    }

}
