package test;

public class LC887SuperEggDrop {
    public int superEggDrop(int K, int N) {
        int m = 0; // 次数

        // dp[M][K]means that, given M moves and K eggs,
        // what is the maximum number of floor that we can check.
        int[][] dp = new int[N + 1][K + 1];
        while (dp[m][K] < N) {
            m++;
            for (int k = 1; k <= K; k++) {
                //          第m次鸡蛋破碎        第m次鸡蛋没有破碎
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int a = 1;

    }
}
