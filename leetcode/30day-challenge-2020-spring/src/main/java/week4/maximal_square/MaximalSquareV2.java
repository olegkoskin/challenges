package week4.maximal_square;

/**
 * Maximal Square.
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Output: 4
 */
public class MaximalSquareV2 {

    /**
     * Recursion with memoization approach.
     *
     * @param matrix matrix
     * @return the largest square area or 0
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] memo = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                memo[i][j] = -1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int val = recursion(i, j, matrix, memo);
                    max = Math.max(max, val);
                }
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max * max;
    }

    private int recursion(int i, int j, char[][] matrix, int[][] memo) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (0 <= i && i < rows && 0 <= j && j < cols) {
            if (memo[i][j] != -1) {
                return memo[i][j];
            }

            if (matrix[i][j] == '1' ) {
                return Math.min(recursion(i, j + 1, matrix, memo), Math.min(recursion(i + 1, j + 1, matrix, memo), recursion(i + 1, j, matrix, memo))) + 1;
            } else {
                memo[i][j] = 0;
            }

            return memo[i][j];
        }

        return 0;
    }

}
