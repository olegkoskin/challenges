package week1.single_number;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SingleNumberV2 {

    public static void main(String[] args) {
        SingleNumberV2 singleNumber = new SingleNumberV2();

        assert singleNumber.singleNumber(new int[]{2, 2, 1}) == 1;
        assert singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}) == 4;
    }

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
