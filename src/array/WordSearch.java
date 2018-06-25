package array;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (exist(board, i, j, w, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int x, int y, char[] word, int i){
        if (i == word.length) return true;
        if (x < 0 || y < 0 || x >= board.length || y >= board[x].length)
            return false;

        if (board[x][y] != word[i]) return false;

        board[x][y] ^= 256; // convert ascii to non-ascii

        boolean isExist = exist(board, x+1, y, word, i+1) ||
                exist(board, x-1, y, word, i+1) ||
                exist(board, x, y+1, word, i+1) ||
                exist(board, x, y-1, word, i+1);

        board[x][y] ^= 256; // restore to ascii
        return isExist;
    }
}
