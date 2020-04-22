package week4.subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

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
public class SubarraySumEqualsK {

    /**
     * Presum hash map.
     *
     * 1. Hashmap<sum[0,i - 1], frequency>
     * 2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
     *        k           sum      hashmap-key     -->  hashmap-key  =  sum - k
     * 3. now, we have k and sum.
     *       As long as we can find a sum[0, i - 1], we then get a valid subarray
     *      which is as long as we have the hashmap-key,  we then get a valid subarray
     * 4. Why don't map.put(sum[0, i - 1], 1) every time ?
     *       if all numbers are positive, this is fine
     *       if there exists negative number, there could be preSum frequency > 1
     *
     * @param nums nums
     * @param k    k
     * @return the total number of continuous subarrays
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int subarrayNumber = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k)) {
                subarrayNumber += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return subarrayNumber;
    }

}
