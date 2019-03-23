package algorithms;

/*
782. Transform to Chessboard
Hard

73

80

Favorite

Share
An N x N board contains only 0s and 1s. In each move, you can swap any 2 rows with each other, or any 2 columns with each other.

What is the minimum number of moves to transform the board into a "chessboard" - a board where no 0s and no 1s are 4-directionally adjacent? If the task is impossible, return -1.

Examples:
Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
Output: 2
Explanation:
One potential sequence of moves is shown below, from left to right:

0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101

The first move swaps the first and second column.
The second move swaps the second and third row.


Input: board = [[0, 1], [1, 0]]
Output: 0
Explanation:
Also note that the board with 0 in the top left corner,
01
10

is also a valid chessboard.

Input: board = [[1, 0], [1, 0]]
Output: -1
Explanation:
No matter what sequence of moves you make, you cannot end with a valid chessboard.
 */

/*
Solution:
Intuition:
Two conditions to help solve this problem:

In a valid chess board, there are 2 and only 2 kinds of rows and one is inverse to the other.
For example if there is a row 01010011 in the board, any other row must be either 01010011 or 10101100.
The same for columns
A corollary is that, any rectangle inside the board with corners top left, top right, bottom left, bottom right must be 4 zeros or 2 ones 2 zeros or 4 zeros.

Another important property is that every row and column has half ones. Assume the board is N * N:
If N = 2*K, every row and every column has K ones and K zeros.
If N = 2*K + 1, every row and every column has K ones and K + 1 zeros or K + 1 ones and K zeros.


Explanation:
Since the swap process does not break this property, for a given board to be valid, this property must hold.
These two conditions are necessary and sufficient condition for a valid chessboard.

Once we know it is a valid cheese board, we start to count swaps.
Basic on the property above, when we arange the first row, we are actually moving all columns.

I try to arrange one row into 01010 and 10101 and I count the number of swaps.

In case of N even, I take the minimum swaps, because both are possible.
In case of N odd, I take the even swaps.
Because when we make a swap, we move 2 columns or 2 rows at the same time.
So col swaps and row swaps should be same here.
 */
public class LetterCasePermutation {
    public int movesToChessboard(int[][] b) {
        int N = b.length, rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                if ((b[0][0] ^ b[i][0] ^ b[0][j] ^ b[i][j]) == 1) return -1;
        for (int i = 0; i < N; ++i) {
            rowSum += b[0][i];
            colSum += b[i][0];
            if (b[i][0] == i % 2) rowSwap++;
            if (b[0][i] == i % 2) colSwap++;
        }
        if (rowSum != N / 2 && rowSum != (N + 1) / 2) return -1;
        if (colSum != N / 2 && colSum != (N + 1) / 2) return -1;
        if (N % 2 == 1) {
            if (colSwap % 2 == 1) colSwap = N - colSwap;
            if (rowSwap % 2 == 1) rowSwap = N - rowSwap;
        } else {
            colSwap = Math.min(N - colSwap, colSwap);
            rowSwap = Math.min(N - rowSwap, rowSwap);
        }
        return (colSwap + rowSwap) / 2;
    }

    // detailed
    public int movesToChessboardOpt(int[][] board) {
        int N = board.length, colToMove = 0, rowToMove = 0, rowOneCnt = 0, colOneCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((board[0][0] ^ board[i][0]) ^ (board[i][j] ^ board[0][j])) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            rowOneCnt += board[0][i];
            colOneCnt += board[i][0];
            if (board[i][0] == i % 2) {
                rowToMove++;
            }
            if (board[0][i] == i % 2) {
                colToMove++;
            }
        }
        if (rowOneCnt < N / 2 || rowOneCnt > (N + 1) / 2) {
            return -1;
        }
        if (colOneCnt < N / 2 || colOneCnt > (N + 1) / 2) {
            return -1;
        }
        if (N % 2 == 1) {
            // we cannot make it when ..ToMove is odd
            if (colToMove % 2 == 1) {
                colToMove = N - colToMove;
            }
            if (rowToMove % 2 == 1) {
                rowToMove = N - rowToMove;
            }
        } else {
            colToMove = Math.min(colToMove, N - colToMove);
            rowToMove = Math.min(rowToMove, N - rowToMove);
        }
        return (colToMove + rowToMove) / 2;
    }

    public static void main(String[] args) {
        int[][] b = {{1, 0}, {1, 0}};
        LetterCasePermutation solution = new LetterCasePermutation();
        int steps = solution.movesToChessboard(b);
        //System.out.println(steps);

        b = new int[][]{{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
        steps = solution.movesToChessboardOpt(b);
        System.out.println(steps);
    }
}
