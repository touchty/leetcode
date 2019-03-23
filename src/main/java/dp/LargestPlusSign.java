package dp;

import java.util.Arrays;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }

        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
            }
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }


    public int orderOfLargestPlusSignDetailed(int N, int[][] mines) {
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(grid[i], N);
        }

        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0, l = 0; j < N; j++) {
                // j is a column index, iterate from left to right
                // every time check how far left it can reach.
                // if grid[i][j] is 0, l needs to start over from 0 again, otherwise increment
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));
            }

            for (int k = N - 1, r = 0; k >= 0; k--) {
                // k is a column index, iterate from right to left
                // every time check how far right it can reach.
                // if grid[i][k] is 0, r needs to start over from 0 again, otherwise increment
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));
            }

            for (int j = 0, u = 0; j < N; j++) {
                // j is a row index, iterate from top to bottom
                // every time check how far up it can reach.
                // if grid[j][i] is 0, u needs to start over from 0 again, otherwise increment
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));
            }

            for (int k = N - 1, d = 0; k >= 0; k--) {
                // k is a row index, iterate from bottom to top
                // every time check how far down it can reach.
                // if grid[k][i] is 0, d needs to start over from 0 again, otherwise increment
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));
            }

            // after four loops each time taking Math.min over the grid value itself
            // all grid values will eventually take the min of the 4 direcitons.
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }
}
