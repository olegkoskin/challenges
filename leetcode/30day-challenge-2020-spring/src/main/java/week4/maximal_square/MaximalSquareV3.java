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
public class MaximalSquareV3 {

    /**
     * Recursion approach.
     *
     * @param matrix matrix
     * @return the largest square area or 0
     */
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int val = recursion(i, j, matrix);
                    max = Math.max(max, val);
                }
            }
        }

        return max * max;
    }

    private int recursion(int i, int j, char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (0 <= i && i < rows && 0 <= j && j < cols) {
            if (matrix[i][j] == '1' ) {
                return Math.min(recursion(i, j + 1, matrix), Math.min(recursion(i + 1, j + 1, matrix), recursion(i + 1, j, matrix))) + 1;
            }
        }

        return 0;
    }

}
