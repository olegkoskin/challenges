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
public class MoveZeroesV3 {

    /**
     * A snowball approach. The idea is that we go through the array and gather all zeros on our road.
     *
     * @param nums nums
     */
    public void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                nums[i - snowBallSize] = nums[i];
                nums[i] = 0;
            }
        }
    }

}
