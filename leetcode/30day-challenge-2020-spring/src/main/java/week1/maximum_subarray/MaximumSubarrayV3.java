package week1.maximum_subarray;

/**
 * Maximum Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Input: [-1],
 * Output: -1.
 * <p>
 * Input: [1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4],
 * Output: 6
 * Explanation: [2, 1, -2, 1, 4] has the largest sum = 6.
 * <p>
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaximumSubarrayV3 {

    /**
     * Brute force approach.
     *
     * @param nums an integer array
     * @return max subarray sum
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];

        for (int i = 0, length = nums.length; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}
