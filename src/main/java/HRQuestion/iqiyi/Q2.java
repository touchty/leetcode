package HRQuestion.iqiyi;

public class Q2 {
    double aWin(int r, int b) {
        double[][] dp = new double[r + 1][b + 1];
        dp[0][0] = 0;
        dp[1][0] = 1;
        dp[2][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][1] = 0.5;
        dp[1][2] = 1 / (3.0);
        dp[2][1] = 2 / (3.0);
        dp[2][2] = 2 / (3.0);

        for (int i = 3; i <= r; i++) {
            for (int j = 3; j <= b; j++) {
                dp[i][j] =
            }
        }
    }

    public static void main(String[] args) {
        int r = 3;
        int b = 4;
        Q2 s = new Q2();
        System.out.println(s.aWin(r, b));
    }
}
