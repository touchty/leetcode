package dp;

public class MaximalSquare {
    /*
    * dp[i][j] 代表在以i, j这一格为右下角的正方形边长。
       如果这一格的值也是1，那这个正方形的边长就是他的上面，
       左手边，和斜上的值的最小边长 +1。因为如果有一边短了缺了，
       都构成不了正方形。
    */
    public int maximalSquare(char[][] a) {
        if (a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (a[i - 1][j - 1] == '1') {

                    b[i][j] = Math.min(Math.min(b[i][j - 1], b[i - 1][j - 1]), b[i - 1][j]) + 1;

                    result = Math.max(b[i][j], result); // update result

                }
            }
        }
        return result * result;
    }

    public int maximalSquareRewrite(char[][] a) {
        if (a.length == 0)
            return 0;

        //  dp[i][j] represents the length of the square with
        //  its right down most part in a[i - 1][j - 1]

        int m = a.length;
        int n = a[0].length;

        int[][] dp = new int[m + 1][n + 1];
        int edge = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i - 1][j - 1]),dp[i][j-1]) + 1;
                    edge = Math.max(edge, dp[i][j]);
                }
            }
        }
        return edge*edge;
    }

}
