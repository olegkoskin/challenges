package week1.single_number;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumberV2 {

    /**
     * Map counter approach.
     *
     * @param nums nums
     * @return single number
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();

        for (int num : nums) {
            numToCount.merge(num, 1, Integer::sum);
        }

        return numToCount.entrySet().stream()
                .filter(it -> it.getValue() == 1)
                .map(Entry::getKey)
                .findAny().orElseThrow(() -> new RuntimeException("Integer array doesn't have a single number."));
    }

}
