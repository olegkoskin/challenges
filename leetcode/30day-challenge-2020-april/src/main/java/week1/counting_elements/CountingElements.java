package week1.counting_elements;

import java.util.Arrays;

/**
 * Counting Elements.
 * <p>
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * <p>
 * If there're duplicates in arr, count them seperately.
 * <p>
 * Example 1:
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * <p>
 * Example 2:
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * <p>
 * Example 3:
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * <p>
 * Example 4:
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 * <p>
 * Constraints:
 * <ol>
 *     <li>1 <= arr.length <= 1000</li>
 *     <li>0 <= arr[i] <= 1000</li>
 * </ol>
 * Hint #1: Use hashset to store all elements.
 * Hint #2: Loop again to count all valid elements.
 */
public class CountingElements {

    /**
     * Sorting and binary search.
     *
     * @param arr integer array
     * @return counting
     */
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int counting = 0;
        for (int num : arr) {
            if (Arrays.binarySearch(arr, num + 1) >= 0) {
                counting++;
            }
        }
        return counting;
    }

}
