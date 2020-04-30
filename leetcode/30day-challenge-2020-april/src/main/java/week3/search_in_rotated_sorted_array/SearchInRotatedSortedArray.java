package week3.search_in_rotated_sorted_array;

import java.util.Arrays;

/**
 * Search in Rotated Sorted Array.
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    /**
     * We need find a pivot point, and divide the array in two sub-arrays, and use the binary search.
     *
     * @param nums nums
     * @param target target
     * @return return target's index if it's found in array, otherwise -1
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int length = nums.length;

        if (length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = nums[0];
        int pivotEnd = length;

        if (pivot == target) {
            return 0;
        }

        for (int i = 1; i < length; i++) {
            if (nums[i] == target) {
                return i;
            }

            if (nums[i] < pivot) {
                pivotEnd = i;
                break;
            }
        }

        int index = target >= pivot
                ? Arrays.binarySearch(nums, 0, pivotEnd, target)
                : Arrays.binarySearch(nums, pivotEnd, length, target);
        return index < 0 ? -1 : index;
    }

}
