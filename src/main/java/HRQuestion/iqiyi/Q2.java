package HRQuestion.iqiyi;

public class Q2 {
    double aWin(int r, int b) {
        // dp[i][j][k]
        double[][][] dp = new double[r + 1][b + 1][3];
        dp[1][0][0] = 1;
        dp[2][0][0] = 1;

        dp[1][0][1] = 1;
        dp[2][0][1] = 1;

        dp[1][0][2] = 1;
        dp[2][0][2] = 1;

        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        return 0;
    }

    public static void main(String[] args) {
        int r = 3;
        int b = 4;
        Q2 s = new Q2();
        System.out.println(s.aWin(r, b));
    }
}
