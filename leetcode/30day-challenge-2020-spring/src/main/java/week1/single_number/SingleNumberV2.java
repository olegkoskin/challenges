package week1.single_number;

public class SingleNumberV2 {

  public static void main(String[] args) {
    SingleNumberV2 singleNumber = new SingleNumberV2();

    assert singleNumber.singleNumber(new int[] {2,2,1}) == 1;
    assert singleNumber.singleNumber(new int[] {4,1,2,1,2}) == 4;
  }

  public int singleNumber(int[] nums) {
    int single = nums[0];

    for (int i = 1; i < nums.length; i++) {
      single ^= nums[i];
    }

    return single;
  }

}
