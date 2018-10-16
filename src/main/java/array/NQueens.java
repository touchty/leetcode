package array;

import java.util.*;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';


        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }

    void dfs(char[][] board, int col, List<List<String>> res) {
        if (col == board.length) {
            res.add(build(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (valid(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, col + 1, res);
                board[row][col] = '.';
            }
        }

    }

    boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if ((board[i][j] == 'Q') && ((row +j == col + i) || (row+col == i+j) || row == i))
                    return false;
            }
        }
        return true;
    }

    List<String> build(char[][] board) {
        List<String> list = new ArrayList();
        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);
            list.add(str);
        }
        return list;
    }
}
