package dp;

import java.util.Arrays;

public class KnightProbabilityinChessboard {
    int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        int len = N;
        double dp0[][] = new double[len][len];
        for(double[] row : dp0) Arrays.fill(row, 1);
        for(int l = 0; l < K; l++) {
            double[][] dp1 = new double[len][len];
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    for(int[] move : moves) {
                        int row = i + move[0];
                        int col = j + move[1];
                        if(isLegal(row, col, len)) dp1[i][j] += dp0[row][col];
                    }
                }
            }
            dp0 = dp1;
        }
        return dp0[r][c] / Math.pow(8, K);
    }
    private boolean isLegal(int r, int c, int len) {
        return r >= 0 && r < len && c >= 0 && c < len;
    }

    class Solution {
        int[][] moves = {{1,2},{1,-2},{-1,2},{-1,-2},{2,-1},{2,1},{-2,-1},{-2,1}};
        public double knightProbability(int N, int K, int r, int c) {
            double[][][] dp = new double[K+1][N][N];
            return helper(dp, N, K, r, c)/Math.pow(8.0, K);
        }
        private double helper(double[][][] dp, int N, int k, int r, int c) {
            if (r < 0 || r >= N || c < 0 || c >= N) return 0.0;
            if (k == 0) return 1.0;
            if (dp[k][r][c] != 0.0) return dp[k][r][c];
            for (int i = 0; i < 8; i++)
                dp[k][r][c] += helper(dp, N, k-1, r+moves[i][0], c+moves[i][1]);
            return dp[k][r][c];
        }
    }

}
