package week3.leftmost_column_with_at_least_a_one;

import java.util.List;

/**
 * Leftmost Column with at Least a One.
 *
 * (This problem is an interactive problem.)
 *
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 *
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 *
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * <ul>
 *     <li>BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y) (0-indexed).</li>
 *     <li>BinaryMatrix.dimensions() returns a list of 2 elements [n, m], which means the matrix is n * m.</li>
 * </ul>
 *
 * Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
 *
 * For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 *
 * Example 1:
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 *
 * Example 2:
 * Input: mat = [[0,0],[0,1]]
 * Output: 1
 *
 * Example 3:
 * Input: mat = [[0,0],[0,0]]
 * Output: -1
 *
 * Example 4:
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 *
 * <b>Constraints:</b>
 * <ul>
 *     <li>1 <= mat.length, mat[i].length <= 100</li>
 *     <li>mat[i][j] is either 0 or 1.</li>
 *     <li>mat[i] is sorted in a non-decreasing way.</li>
 * </ul>
 *
 * <b>Hint #1: (Binary Search) For each row do a binary search to find the leftmost one on that row and update the answer.</b>
 * <b>Hint #2: (Optimal Approach) Imagine there is a pointer p(x, y) starting from top right corner. p can only move
 * left or down. If the value at p is 0, move down. If the value at p is 1, move left. Try to figure out the correctness
 * and time complexity of this algorithm.</b>
 */
public class LeftmostColumnWithAtLeastAOne {

    /**
     * Top right corner to lef and down approach.
     *
     * Imagine there is a pointer p(x, y) starting from top right corner. p can only move left or down.
     * If the value at p is 0, move down. If the value at p is 1, move left. Try to figure out the correctness and time
     * complexity of this algorithm.
     *
     * O(nlogm)
     *
     * @param binaryMatrix matrix
     * @return leftmost column index(0-indexed) with at least a 1 in it
     */
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int n = dimensions.get(0);
        int m = dimensions.get(1);
        int leftmost = -1;

        int left = 0;
        int right = m;

        for (int row = 0; row < n; row++) {
            left = 0;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (binaryMatrix.get(row, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            leftmost = left;
        }

        return leftmost == m ? -1 : leftmost;
    }

}
