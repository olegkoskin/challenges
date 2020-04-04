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
public class MaximumSubarray {

    /**
     * Kadane’s Algorithm. Dynamic programming.
     * <p>
     * local_maximum at index i is the maximum of A[i] and the sum of A[i] and local_maximum at index i-1.
     *
     * @param nums an integer array
     * @return max subarray sum
     */
    public int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int maxSum = nums[0];

        for (int i = 1, length = nums.length; i < length; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, localMax);
        }

        return maxSum;
    }
}
