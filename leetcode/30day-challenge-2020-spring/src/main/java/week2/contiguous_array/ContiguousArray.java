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
public class ContiguousArray {

    /**
     * Using Integer array as map.
     *
     * O(n)
     *
     * @param nums nums
     * @return max sub array length
     */
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        int sum = 0;
        Integer[] map = new Integer[length * 2 + 1];
        map[length] = -1;

        for (int i = 0; i < length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            int index = length - sum;

            if (map[index] != null) {
                maxLength = Math.max(i - map[index], maxLength);
            } else {
                map[index] = i;
            }
        }
        return maxLength;
    }

}
