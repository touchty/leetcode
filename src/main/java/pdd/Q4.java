package pdd;

import java.util.Arrays;

// 长度为n的递增数组(正整数)，和为s,有多少种可能！
public class Q4 {
    int[][] dp; // 记忆中间结果
    final int mod = 1000000007;

    int count(int n, int s) {
        dp = new int[n + 1][s + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int nums = helper(n, s);
        return nums;
    }

    private int helper(int n, int s) {
        if (s <= 0)
            return 0;
        if (n * (n + 1) / 2 > s)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n][s] >= 0)
            return dp[n][s];
        // 以递增数组开头的值，大于1和等于1
        dp[n][s] = helper(n, s - n) + helper(n - 1, s - n);
        if (dp[n][s] >= mod)
            dp[n][s] -= mod;
        return dp[n][s];
    }

    public static void main(String[] args) {
        int n = 2;
        int s = 10;
        Q4 solution = new Q4();
        int ways = solution.count(n, s);
        System.out.println(ways);
    }
}
