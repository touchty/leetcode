package test;

import java.util.Arrays;

public class CoinChangeI {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = amount + 1;
            }
        }
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i)
                    dp[j + 1][i] = Math.min(dp[j][i], 1 + dp[j + 1][i - coins[j]]);
                    //                            ^ 不使用coins[j-1]    ^ 使用coins[j-1]
                else
                    dp[j + 1][i] = dp[j][i];

            }
        }

        if (dp[coins.length][amount] == amount + 1)
            return -1;
        return dp[coins.length][amount];
    }


    public int coinChange1D(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        Arrays.fill(dp, amount + 1);
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]]);
                }
            }
        }
        if (dp[amount] == amount + 1)
            return -1;
        else
            return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChangeI solution = new CoinChangeI();
        int res = solution.coinChange(coins, amount);
        System.out.println(res);
    }
}
