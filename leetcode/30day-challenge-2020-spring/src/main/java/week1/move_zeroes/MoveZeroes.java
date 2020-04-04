package week1.move_zeroes;

/**
 * Move Zeroes
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
 * the non-zero elements.
 * <p>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 */
public class MoveZeroes {

    /**
     * A two-pointer approach. The idea would be to have one pointer for iterating the array and another pointer that
     * just works on the non-zero elements of the array.
     *
     * @param nums nums
     */
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        for (int i = nonZeroIndex; i < length; i++) {
            nums[i] = 0;
        }
    }

}
