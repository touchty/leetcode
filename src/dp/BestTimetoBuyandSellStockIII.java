package dp;

public class BestTimetoBuyandSellStockIII {
/*
* Solution is commented in the code. Time complexity is O(kn),
* space complexity can be O(n) because this DP only uses the
* result from last step. But for cleaness this solution still
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

    int maxProfitRewrite(int[] prices) {
        if (prices.length <= 1)
            return 0;

        int K = 2;
        int maxProfit = 0;
        int[][] f = new int[K + 1][prices.length];

        for (int kk = 1; kk < f.length; kk++) {
            int tmpMax = f[kk - 1][0] - prices[0];
            for (int ii = 1; ii < prices.length; ii++) {
                f[kk][ii] = Math.max(f[kk][ii - 1], prices[ii] + tmpMax);
                tmpMax = Math.max(tmpMax, f[kk - 1][ii] - prices[ii]);
                maxProfit = Math.max(f[kk][ii], maxProfit);
            }
        }
        return maxProfit;
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
}

