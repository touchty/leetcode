package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int j = 0; j < coins.length; j++){
            for(int i = 0; i <= amount; i++){
                if(i - coins[j] >= 0) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public int coinChangeRewrite(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);

        Arrays.fill(dp, amount + 1);

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                //  amount j may be split into coins
                if (coins[i] <= j)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]]);
            }
        }
        if (dp[amount] == amount)
            return dp[amount];
        else
            return -1;
    }

    public int coinChangeR1(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // initialize to maximum value
        for (int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;

        // put this at outer loop to (possibly) avoid some dp slots
        for (int coin : coins)
            for(int i = coin ;i < dp.length ; i++)
                // check on possible overflow problem
                if(dp[i-coin] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        // if bigger -> still Max_Value -> not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
