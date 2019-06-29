package test;

import java.util.Arrays;

// LC 322. Coin Change
// 背包问题
// n个不同面板的硬币（每种无限多），然后给出一个总价格amount，
// 问在如何将硬币枚数控制在最少的情况在拼出amount
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int t = 1; t <= amount; t++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= t) {
                    dp[t] = Math.min(dp[t], dp[t - coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == amount + 1)
            return -1;
        else
            return dp[amount];
    }

    public int coinChange2D(int[] coins, int amount) {
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
                    dp[j + 1][i] = dp[j][i]; // coins[j] is too big to use for target i

            }
        }

        if (dp[coins.length][amount] == amount + 1)
            return -1;
        return dp[coins.length][amount];
    }
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 3;
        CoinChange solution = new CoinChange();
        int amount = solution.coinChange2D(coins, target);
        System.out.println(amount);
    }
}
