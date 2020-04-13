package week2.contiguous_array;

/**
 * Contiguous Array.
 * <p>
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Note: The length of the given binary array will not exceed 50,000.
 */
public class ContiguousArrayV2 {

    /**
     * The brute force approach. Very lo-o-ong.
     * irstly check whether the sub-array has equal number of 0’s and 1’s or not. To make this process easy take
     * cumulative sum of the sub-arrays taking 0’s as -1 and 1’s as it is. The point where cumulative sum=0 will
     * signify that the sub-array from starting till that point has equal number of 0’s and 1’s. Now as this is
     * a valid sub-array, compare it’s size with the maximum size of such sub-array found till now.
     *
     * O(n^2)
     *
     * @param nums nums
     * @return max sub array length
     */
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        for (int i = 0; i < length - 1; i++) {
            int sum = nums[i] == 0 ? -1 : 1;
            for (int j = i + 1; j < length; j++) {
                sum += nums[j] == 0 ? -1 : 1;
                if (sum == 0) {
                    maxLength = Math.max(j - i + 1, maxLength);
                }
            }
        }
        return maxLength;
    }

}
