package dp;

import java.util.Arrays;

/**
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 0; i <= amount; i++) {
                if (i - coins[j] >= 0) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeRewrite(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.sort(coins);

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                //  amount j may be split into coins
                if (coins[i] <= j)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeR1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // initialize to maximum value
        for (int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;

        // put this at outer loop to (possibly) avoid some dp slots
        for (int coin : coins)
            for (int i = coin; i < dp.length; i++)
                // check on possible overflow problem
                if (dp[i - coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        // if bigger -> still Max_Value -> not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
