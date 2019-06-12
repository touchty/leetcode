package test;

import java.util.Arrays;

// LC 322. Coin Change
// 背包问题
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

    public static void main(String[] args) {
        int[] coins = {2};
        int target = 3;
        CoinChange solution = new CoinChange();
        int amount = solution.coinChange(coins, target);
        System.out.println(amount);
    }
}
