package week1.single_number;

/**
 * Single Number
 * <p>
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        assert singleNumber.singleNumber(new int[]{2, 2, 1}) == 1;
        assert singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}) == 4;
    }

    public int singleNumber(int[] nums) {
        int single = nums[0];

        for (int i = 1; i < nums.length; i++) {
            single ^= nums[i];
        }

        return single;
    }

}
