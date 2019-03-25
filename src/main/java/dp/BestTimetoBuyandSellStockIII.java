package dp;

/*
123. Best Time to Buy and Sell Stock III
Hard

929

53

Favorite

Share
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

public class BestTimetoBuyandSellStockIII {
    /*
     * Solution is commented in the code. Time complexity is O(kn),
     * space complexity can be O(n) because this DP only uses the
     * result from last step. But for clearness this solution still
     * used O(kn) space complexity to
     * preserve similarity to the equations in the comments.
     * */

    public int maxProfit(int[] prices) {
        // f[k, i] represents the max profit up until prices[i] (Note: NOT ending with prices[i]) using at most k
        // transactions.
        // f[k, i] = max(f[k, i-1], prices[i] - prices[j] + f[k-1, j]) { j in range of [0, i-1] }
        //          = max(f[k, i-1], prices[i] + max(f[k-1, j] - prices[j]))
        // f[0, i] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if (prices.length <= 1) return 0;
        else {
            int K = 2; // number of max transation allowed
            int maxProf = 0;
            int[][] f = new int[K + 1][prices.length];
            for (int k = 1; k <= K; k++) {
                int tmpMax = f[k - 1][0] - prices[0];
                for (int i = 1; i < prices.length; i++) {
                    f[k][i] = Math.max(f[k][i - 1], prices[i] + tmpMax);
                    tmpMax = Math.max(tmpMax, f[k - 1][i] - prices[i]);
                    maxProf = Math.max(f[k][i], maxProf);
                }
            }
            return maxProf;
        }
    }

    public static int MaxProfitDP(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < prices.length; i++) {
                int min = prices[0];
                for (int j = 1; j <= i; j++)
                    min = Math.min(min, prices[j] - dp[k - 1][j - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }

        return dp[2][prices.length - 1];
    }

    public int maxProfitOpt(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int maxProfit = BestTimetoBuyandSellStockIII.MaxProfitDP(prices);
        System.out.println(maxProfit);
    }
}

