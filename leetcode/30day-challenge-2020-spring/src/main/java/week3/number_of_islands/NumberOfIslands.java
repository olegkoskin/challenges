package week3.number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Number of Islands.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * Example 1:
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * Output: 3
 */
public class NumberOfIslands {

    private static final int[] DX = {1,0,0,1};
    private static final int[] DY = {0,1,-1,0};

    private static final int[][] DIRS =  {{-1,0},{1,0},{0,-1},{0,1}};

    /**
     * "Counting the number of connected components in an undirected graph" problem.
     *
     * @param grid grid
     * @return number of islands
     */
    public int numIslands(char[][] grid) {
        /*if(grid==null || grid.length==0) {
            return 0;
        }

        int rowAmount = grid.length;
        int colAmount = grid[0].length;
        boolean[][] visited = new boolean[rowAmount][colAmount];
        int count = 0;
        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < colAmount; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    DFS(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;*/
        if(grid==null || grid.length==0) return 0;
        int islands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    BFS(grid,i,j);
                }
            }
        }
        return islands;
    }

    /*private boolean isSafe(char[][] grid, int row, int col, boolean[][] visited) {
        return row >=0 && row < visited.length
                && col >= 0 && col < visited[0].length
                && grid[row][col] == 1 && !visited[row][col];
    }

    private void DFS(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for(int k = 0; k < 4; k++) {
            if (isSafe(grid, row + DX[k], col + DY[k],visited)) {
                DFS(grid, row + DX[k], col + DY[k],visited);
            }
        }
    }*/

    private void BFS(char[][] grid, int x, int y){
        grid[x][y] = '0';
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x,y));
        while(q.size()>0){
            int size = q.size();
            Point p = q.poll();
            for(int i=0;i<size;i++){
                for(int[] dir: DIRS){
                    int x1 = p.x+dir[0];
                    int y1 = p.y+dir[1];
                    if(x1>=0 && y1>=0 && x1< grid.length && y1<grid[0].length && grid[x1][y1]=='1'){
                        grid[x1][y1] = '0';
                        q.offer(new Point(x1,y1));
                    }
                }
            }
        }
    }

    static class Point{

        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
