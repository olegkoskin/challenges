package week4.jump_game;

/**
 * Jump Game.
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGameV2 {

    /**
     * DP approach.
     *
     * @param nums nums
     * @return true if you are able to reach the last index, otherwise false
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] jump = new boolean[n];
        jump[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i] && j < n; j++) {
                if (jump[i + j]) {
                    jump[i] = true;
                    break;
                }
            }
        }

        return jump[0];
    }

}
