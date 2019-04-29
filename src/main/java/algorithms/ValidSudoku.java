package algorithms;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudokuUsingStrSet(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder builder = new StringBuilder();
                if (board[i][j] != '.') {
                    builder.append(board[i][j]).append("@row").append(i);
                    String s = builder.toString();
                    if (set.contains(s)) return false;
                    else set.add(builder.toString());

                    builder.setLength(0);
                    builder.append(board[i][j]).append("@col").append(j);
                    s = builder.toString();
                    if (set.contains(s)) return false;
                    else set.add(builder.toString());

                    // sub 3x3 box
                    int r = i / 3;
                    int rr = i % 3;
                    int c = j / 3;
                    int cc = j % 3;
                    builder.setLength(0);
                    builder.append(r + "-" + c + "-" + board[i][j]);
                    s = builder.toString();
                    if (set.contains(s)) return false;
                    else set.add(s);
                }

            }
        }
        return true;
    }

    public static boolean isValidRow(char[][] board, int rowIndex) {
        boolean found[] = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[rowIndex][i] == '.')
                continue;
            int c = board[rowIndex][i] - '0';
            if (found[c])
                return false;
            found[c] = true;
        }
        return true;
    }
    public static boolean isValidCol(char[][] board, int colIndex) {
        boolean found[] = new boolean[10];
        for (int i = 0; i < 9; i++) {
            if (board[i][colIndex] == '.')
                continue;
            int c = board[i][colIndex] - '0';
            if (found[c])
                return false;
            found[c] = true;
        }
        return true;
    }
    public static boolean isValidBox(char[][] board, int iStart, int jStart) {
        boolean found[] = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[iStart + i][jStart + j] == '.')
                    continue;
                int c = board[iStart + i][jStart + j] - '0';
                if (found[c])
                    return false;
                found[c] = true;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i))
                return false;
            if (!isValidCol(board, i))
                return false;
        }
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                if (!isValidBox(board, i, j))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] b1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku solution = new ValidSudoku();
        boolean res = solution.isValidSudoku(b1);
        System.out.println(res);

        char[][] b2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean res2 = solution.isValidSudoku(b2);
        System.out.println(res2);

        char[][] b3 = {
                {'5', '3', '9', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean res3 = solution.isValidSudoku(b3);
        System.out.println(res3);

    }
}
