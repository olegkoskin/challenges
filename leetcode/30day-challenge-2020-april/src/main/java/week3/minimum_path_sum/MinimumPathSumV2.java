package week3.minimum_path_sum;

/**
 * Minimum Path Sum.
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes
 * the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSumV2 {

    /**
     * Recursion approach. Depth-First Search. Ver-y-y-y slow.
     *
     * @param grid grid
     * @return minimum path sum
     */
    public int minPathSum(int[][] grid) {
        return path(0, 0, 0, grid);
    }

    private int path(int sum, int row, int col, int[][] grid) {
        if (row >= grid.length || col >= grid[0].length) {
            return sum;
        }

        int curSum = sum + grid[row][col];

        if (row + 1 == grid.length) {
            return path(curSum, row, col + 1, grid);
        }

        if (col + 1 == grid[0].length) {
            return path(curSum, row + 1, col, grid);
        }

        int rightPath = path(curSum, row + 1, col, grid);
        int downPath = path(curSum, row, col + 1, grid);

        return Math.min(rightPath, downPath);
    }

    /*public int minPathSum(int[][] grid) {
        Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> path = path(0, 0, 0, grid, new ArrayList<>(grid.length * grid[0].length));
        return path.getKey();
    }

    private Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> path(int sum, int row, int col, int[][] grid, List<Map.Entry<Integer, Integer>> path) {
        if (row >= grid.length || col >= grid[0].length) {
            return new AbstractMap.SimpleEntry<>(sum, path);
        }

        int curSum = sum + grid[row][col];
        List<Map.Entry<Integer, Integer>> curPath = new ArrayList<>(path);
        curPath.add(new AbstractMap.SimpleEntry<>(row, col));

        if (row + 1 == grid.length) {
            return path(curSum, row, col + 1, grid, curPath);
        }

        if (col + 1 == grid[0].length) {
            return path(curSum, row + 1, col, grid, curPath);
        }

        Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> rightPath = path(curSum, row + 1, col, grid, curPath);
        Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> downPath = path(curSum, row, col + 1, grid, curPath);

        return rightPath.getKey() > downPath.getKey() ?  downPath : rightPath;
    }

    private String displayPath(Map.Entry<Integer, List<Map.Entry<Integer, Integer>>> entry, int[][] grid) {
        Integer sum = entry.getKey();
        List<Map.Entry<Integer, Integer>> path = entry.getValue();
        String collect = path.stream()
                .map((Map.Entry<Integer, Integer> point) -> grid[point.getKey()][point.getValue()] + "")
                .collect(Collectors.joining(" -> "));
        return sum + " : " + collect;
    }*/

}
