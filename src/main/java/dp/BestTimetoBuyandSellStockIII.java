package dp;

public class BestTimetoBuyandSellStockIII {
    /*
     * Solution is commented in the code. Time complexity is O(kn),
     * space complexity can be O(n) because this DP only uses the
     * result from last step. But for clearness this solution still
     * used O(kn) space complexity to
     * preserve similarity to the equations in the comments.
     * */

    public int maxProfit(int[] prices) {
        // f[k, ii] represents the max profit up until prices[ii] (Note: NOT ending with prices[ii]) using at most k transactions.
        // f[k, ii] = max(f[k, ii-1], prices[ii] - prices[jj] + f[k-1, jj]) { jj in range of [0, ii-1] }
        //          = max(f[k, ii-1], prices[ii] + max(f[k-1, jj] - prices[jj]))
        // f[0, ii] = 0; 0 times transation makes 0 profit
        // f[k, 0] = 0; if there is only one price data point you can't make any money no matter how many times you can trade
        if (prices.length <= 1) return 0;
        else {
            int K = 2; // number of max transation allowed
            int maxProf = 0;
            int[][] f = new int[K + 1][prices.length];
            for (int kk = 1; kk <= K; kk++) {
                int tmpMax = f[kk - 1][0] - prices[0];
                for (int ii = 1; ii < prices.length; ii++) {
                    f[kk][ii] = Math.max(f[kk][ii - 1], prices[ii] + tmpMax);
                    tmpMax = Math.max(tmpMax, f[kk - 1][ii] - prices[ii]);
                    maxProf = Math.max(f[kk][ii], maxProf);
                }
            }
            return maxProf;
        }
    }

    int maxProfit1(int k, int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        if (k >= n / 2) { // buy-sell-II case, unlimited
            int maxProfit = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
        // if k<n/2, use DP approach but only O(k) space
        int[] f = new int[k + 1];
        int[] g = new int[k + 1];
        for (int i = 1; i < n; ++i) {
            int diff = prices[i] - prices[i - 1], temp = f[0];
            for (int kk = 1; kk <= k; ++kk) {
                g[kk] = Math.max(g[kk], temp) + diff;
                temp = f[kk];
                f[kk] = Math.max(f[kk], g[kk]);
            }
        }
        return f[k];
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

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int maxProfit = BestTimetoBuyandSellStockIII.MaxProfitDP(prices);
        System.out.println(maxProfit);
    }
}

