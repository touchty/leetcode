public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;
        int width = grid[0].length;

        int[] dp = new int[width];

        dp[0] = grid[0][0];
        for (int i = 1; i < width; i++){
            dp[i] = dp[i - 1] + grid[0][i];
        }

        for (int r = 1; r < grid.length; r++){
            dp[0] = dp[0] + grid[r][0];// vertically
            for (int i = 1; i < width; i++){
                    int min = Math.min(dp[i], dp[i - 1]);//vertically or horizontally
                    dp[i] = min + grid[r][i];
            }

        }

        return dp[width - 1];
    }
}
