package bst;
/*
 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Solution:

First check all surrounding rows columns find those 'O' and their neighbors that are also 'O', make them to some other character like '1'. then traverse the whole board, now the 'O' left need to be turned to 'X', and those marked '1' turned back to 'O'

like this:

X X X X        X X X X         X X X X
X O O X  --->  X O O X   --->  X X X X
X X O X        X X O X         X X X X
X O X X        X 1 X X         X O X X
*/
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0){
            return;
        }
        int row = board.length;
        int column = board[0].length;
        for(int i = 0; i < row; i++){
            // col - 0
            check(board,i,0);
            // col - last one
            check(board,i, column-1);
        }
        for(int j = 0; j < column - 1; j++){
            // row 1
            check(board,0,j);
            // row last one
            check(board,row-1,j);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(board[i][j] == '1') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    void check(char[][] board, int i, int j){
        if (board[i][j] == 'O'){
            board[i][j] = '1';
            if (i > 1) check(board, i-1,j);
            if (j > 1) check(board,i,j-1);
            if (i < board.length-1) check(board,i+1,j);
            if (j < board[0].length-1) check(board,i,j+1);
        }
    }
}
