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
public class MaximumSubarrayV2 {

    /**
     * Divide and conquer approach.
     *
     * @param nums an integer array
     * @return max subarray sum
     */
    public int maxSubArray(int[] nums) {
        return maxSum(0, nums.length - 1, nums);
    }

    private int maxSum(int left, int right, int[] nums) {
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;
        int leftSum = maxSum(left, mid, nums);
        int rightSum = maxSum(mid + 1, right, nums);
        int crossSum = crossSum(left, mid, right, nums);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    private int crossSum(int left, int mid, int right, int[] nums) {
        int leftSum = nums[mid];
        int curSum = nums[mid];

        for (int i = mid - 1; i >= left; i--) {
            curSum += nums[i];
            if (curSum > leftSum) {
                leftSum = curSum;
            }
        }

        curSum = nums[mid + 1];
        int rightSum = nums[mid + 1];

        for (int i = mid + 2; i <= right; i++) {
            curSum += nums[i];
            if (curSum > rightSum) {
                rightSum = curSum;
            }
        }

        return leftSum + rightSum;
    }
}
