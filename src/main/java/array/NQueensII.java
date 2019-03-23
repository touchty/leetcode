package array;

public class NQueensII {
    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';


        dfs(board, 0);
        return count;
    }

    void dfs(char[][] board, int col) {
        if (col == board.length) {
            count++;
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (valid(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, col + 1);
                board[row][col] = '.';
            }
        }

    }

    boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if ((board[i][j] == 'Q') && ((row + j == col + i) || (row + col == i + j) || row == i))
                    return false;
            }
        }
        return true;
    }

    static class Solution {
        int count = 0;

        public int totalNQueens(int n) {
            boolean[] cols = new boolean[n];     // columns   |
            boolean[] d1 = new boolean[2 * n];   // diagonals \
            boolean[] d2 = new boolean[2 * n];   // diagonals /
            backtracking(0, cols, d1, d2, n);
            return count;
        }

        public void backtracking(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
            if (row == n) count++;

            for (int col = 0; col < n; col++) {
                int id1 = col - row + n;
                int id2 = col + row;
                if (cols[col] || d1[id1] || d2[id2]) continue;

                cols[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                backtracking(row + 1, cols, d1, d2, n);
                cols[col] = false;
                d1[id1] = false;
                d2[id2] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new NQueensII.Solution();
        int res = s.totalNQueens(7);
        System.out.println(res);
    }
}
