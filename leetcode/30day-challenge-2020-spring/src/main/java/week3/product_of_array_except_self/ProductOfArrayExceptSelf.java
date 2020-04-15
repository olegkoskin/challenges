package week3.product_of_array_except_self;

/**
 * Product of Array Except Self.
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * <b>Constraint:</b> It's guaranteed that the product of the elements of any prefix or suffix of the array
 * (including the whole array) fits in a 32 bit integer.
 *
 * <b>Note:</b> Please solve it without division and in O(n).
 *
 * <b>Follow up:</b>
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose
 * of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    /**
     * One array
     *
     * @param nums nums
     * @return array of product except self
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        output[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            output[i] = output[i + 1] * nums[i + 1];
        }
        int elementMultiplyer = 1;
        for (int i = 0; i < length; i++) {
            output[i] *= elementMultiplyer;
            elementMultiplyer *= nums[i];
        }
        return output;
    }

}
