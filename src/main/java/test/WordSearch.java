package test;

public class WordSearch {
    boolean res = false;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (res) return true;
                dfs(board, i, j, 0, word, new boolean[board.length][board[0].length]);
            }
        }
        return res;
    }

    void dfs(char[][] board, int i, int j, int index, String word, boolean[][] v) {
        if (index == word.length()) {
            res = true;
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || v[i][j] || res)
            return;


        if (board[i][j] != word.charAt(index)) return;
        v[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(board, x, y, index + 1, word, v);
        }
        v[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'}};
        String word = "a";
        WordSearch solution = new WordSearch();
        boolean res = solution.exist(board, word);
        System.out.println(res);
    }
}
