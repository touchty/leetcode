package dp;

public class DPLearning {
    // how many ways
    /*
    518. Coin Change 2
    Medium

    693

    34

    Favorite

    Share
    You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



    Example 1:

    Input: amount = 5, coins = [1, 2, 5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1
     */
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            int coin = coins[i - 1];
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coin ? dp[i][j - coin] : 0);
            }
        }

        return dp[coins.length][amount];
    }

    // minimum counts
    /*
    322. Coin Change
    Medium

    1594

    70

    Favorite

    Share
    You are given coins of different denominations and a total amount of money amount. Write a function to compute the
    fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;
        int[] minNumber = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumber[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minNumber[i - coins[j]] != Integer.MAX_VALUE)
                    minNumber[i] = Integer.min(minNumber[i], 1 + minNumber[i - coins[j]]);
            }
        }
        if (minNumber[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return minNumber[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        DPLearning s = new DPLearning();
        int minCoins = s.coinChange(coins, amount);
        System.out.println(minCoins);
    }

}
