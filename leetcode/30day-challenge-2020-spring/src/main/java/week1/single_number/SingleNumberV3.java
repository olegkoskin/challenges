package week1.single_number;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberV3 {

  public static void main(String[] args) {
    SingleNumberV3 singleNumber = new SingleNumberV3();

    assert singleNumber.singleNumber(new int[] {2,2,1}) == 1;
    assert singleNumber.singleNumber(new int[] {4,1,2,1,2}) == 4;
  }

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> hash1 = new HashMap<>(nums.length);

    for (int num: nums) {
      if (hash1.containsKey(num)) {
        hash1.remove(num);
      } else {
        hash1.put(num, 1);
      }
    }

    return hash1.keySet().iterator().next();
  }

}
