package offer;

public class O47GetMost {
    public int getMost(int[][] values) {
        int row = values.length;
        int col = values[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = values[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] += values[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < col; i++) {
            dp[0][i] += values[0][i] + dp[0][i - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + values[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{426, 306, 641, 372, 477, 409}, {223, 172, 327, 586, 363, 553}, {292, 645, 248, 316, 711, 295}, {127, 192, 495
                , 208, 547, 175}, {131, 448, 178, 264, 207, 676}, {655, 407, 309, 358, 246, 714}};

        O47GetMost solution = new O47GetMost();
        int res = solution.getMost(matrix);
        System.out.println(res);
    }
}
