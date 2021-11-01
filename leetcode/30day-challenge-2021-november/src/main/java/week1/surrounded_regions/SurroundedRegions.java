package week1.surrounded_regions;

/**
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * <b>Example 1:</b>
 * <b>Input:</b> board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * <b>Output:</b> [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * <b>Explanation:</b> Surrounded regions should not be on the border, which means that any 'O'
 * on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and
 * it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected
 * if they are adjacent cells connected horizontally or vertically.
 *
 * <b>Example 2:</b>
 * <b>Input:</b> board = [["X"]]
 * <b>Output:</b> [["X"]]
 *
 * <b>Constraints:</b>
 * <ul>
 *   <li>m == board.length</li>
 *   <li>n == board[i].length</li>
 *   <li>1 <= m, n <= 200</li>
 *   <li>board[i][j] is 'X' or 'O'.</li>
 * </ul>
 */
public class SurroundedRegions {

  public void solve(char[][] board) {
    int rows = board.length;

    if (rows == 0) {
      return;
    }

    int cols = board[0].length;

    // 1st Loop : Traversing over top column & bottom column, to find any 'O' present by the boundary
    for (int i = 0; i < cols; i++) {
      if (board[0][i] == 'O') {
        DFS(board, 0, i);
      }

      if (board[rows - 1][i] == 'O') {
        DFS(board, rows - 1, i);
      }
    }

    // 2nd Loop : Traversing over left row & right row, to find any 'O' present by the boundary
    for (int i = 0; i < rows; i++) {
      if (board[i][0] == 'O') {
        DFS(board, i, 0);
      }

      if (board[i][cols - 1] == 'O') {
        DFS(board, i, cols - 1);
      }
    }

    // 3rd Loop : Now in this we will traverse on each n every node
    // & check if they are 'O' convert into 'X', if they are '@' convert into 'O'
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == '#') {
          board[i][j] = 'O';
        }
      }
    }
  }

  public void DFS(char[][] board, int i, int j) {
    int rows = board.length;
    int cols = board[0].length;

    // This calls helps in convert the 'O' node present near by the boundary convert them into '@'
    if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
      return;
    }

    board[i][j] = '#';
    DFS(board, i + 1, j);
    DFS(board, i - 1, j);
    DFS(board, i, j + 1);
    DFS(board, i, j - 1);
  }

}