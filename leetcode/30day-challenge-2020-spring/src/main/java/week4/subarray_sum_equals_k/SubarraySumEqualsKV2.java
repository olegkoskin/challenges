package week4.subarray_sum_equals_k;

/**
 * Subarray Sum Equals K.
 * <p>
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 * whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * <b>Note:</b>
 * <ul>
 *     <li>The length of the array is in range [1, 20,000].</li>
 *     <li>The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].</li>
 * </ul>
 *
 * <b>Hint #1:</b> Will Brute force work here? Try to optimize it.
 * <p>
 * <b>Hint #2:</b> Can we optimize it by using some extra space?
 * <p>
 * <b>Hint #3:</b> What about storing sum frequencies in a hash table? Will it be useful?
 * <p>
 * <b>Hint #4:</b> sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1.
 * Can we use this property to optimize it.
 */
public class SubarraySumEqualsKV2 {

    /**
     * Brute force approach with prefix sum.
     *
     * @param nums nums
     * @param k    k
     * @return the total number of continuous subarrays
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int subarrayNumber = 0;

        for (int x=1; x < length; x++) {
            nums[x] += nums[x - 1];
        }

        for (int x=0; x < length; x++) {
            if (nums[x] == k) {
                subarrayNumber++;
            }

            for (int y=x+1; y < length; y++) {
                if (nums[y] - nums[x] == k) {
                    subarrayNumber++;
                }
            }
        }

        return subarrayNumber;
    }

}
