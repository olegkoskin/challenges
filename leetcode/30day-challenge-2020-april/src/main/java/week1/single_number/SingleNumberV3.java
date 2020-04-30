package week1.single_number;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberV3 {

    /**
     * Map contain approach.
     *
     * @param nums nums
     * @return single number
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> hash1 = new HashMap<>(nums.length);

        for (int num : nums) {
            if (hash1.containsKey(num)) {
                hash1.remove(num);
            } else {
                hash1.put(num, 1);
            }
        }

        return hash1.keySet().iterator().next();
    }

}
