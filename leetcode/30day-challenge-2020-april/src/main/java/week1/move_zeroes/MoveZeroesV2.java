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
public class MoveZeroesV2 {

    /**
     * A two inner loops approach.
     *
     * @param nums nums
     */
    public void moveZeroes(int[] nums) {
        for (int i = 0, length = nums.length; i < length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

}
