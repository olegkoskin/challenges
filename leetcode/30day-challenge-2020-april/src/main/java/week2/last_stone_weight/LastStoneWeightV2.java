package week2.last_stone_weight;

import java.util.Arrays;

/**
 * Last Stone Weight.
 * <p>
 * We have a collection of stones, each stone has a positive integer weight.
 * <p>
 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y
 * with x <= y.  The result of this smash is:
 * <ul>
 *     <li>If x == y, both stones are totally destroyed;</li>
 *     <li>If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.</li>
 * </ul>
 * <p>
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * <p>
 * <b>Example 1:</b>
 * Input: [2,7,4,1,8,1]
 * Output: 1
 * Explanation:
 * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 * <p>
 * <b>Note:</b>
 * <ol>
 *     <li>1 <= stones.length <= 30</li>
 *     <li>1 <= stones[i] <= 1000</li>
 * </ol>
 */
public class LastStoneWeightV2 {

    /**
     * Recursion approach.
     *
     * @param stones stones
     * @return las stone weight
     */
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }

        if (stones.length == 1) {
            return stones[0];
        }

        Arrays.sort(stones);
        int length = stones.length;
        int x = stones[length - 2];
        int y = stones[length - 1];

        if (x == y) {
            stones = Arrays.copyOf(stones, length - 2);
        } else {
            stones = Arrays.copyOf(stones, length - 1);
            stones[length - 2] = y - x;
        }
        return lastStoneWeight(stones);
    }

}
