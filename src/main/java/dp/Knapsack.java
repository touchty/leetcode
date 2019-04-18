package dp;

import org.junit.Assert;

class Knapsack {

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSackRecursive(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSackRecursive(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else
            return Math.max(
                    val[n - 1]
                            + knapSackRecursive(W - wt[n - 1], wt, val, n - 1),
                    knapSackRecursive(W, wt, val, n - 1));
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSackIterative(int W, int wt[], int val[], int n) {

        // dp[i][j] stores the maximum value when there are i element and the
        // knapstack is j
        int[][] dp = new int[n + 1][W + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * case1: 带上第i个元素，获得收益val[i] case2: 不带上第i个元素
                     */
                    int val1 = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    int val2 = dp[i - 1][j];

                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }

        return dp[n][W];
    }


    // Returns the maximum weight that can be put in a knapsack of capacity W
    static int knapSackIterativeWeight(int W, int wt[]) {
        int n = wt.length;

        // dp[i][j] stores the maximum value when there are i element and the
        // knapstack is j
        int[][] dp = new int[n + 1][W + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int weight = wt[i - 1];
                if (weight > j) { // 0 - cannot put into sack
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * case1: 带上第i个元素，获得收益val[i] case2: 不带上第i个元素
                     */
                    int val1 = weight + dp[i - 1][j - weight];
                    int val2 = dp[i - 1][j];

                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }

        return dp[n][W];
    }

    // Driver program to test above function
    public static void main(String args[]) {
        /*int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 51;
        int n = val.length;
        System.out.println(knapSackIterative(W, wt, val, n));*/

        int val[] = new int[]{10, 15, 5};
        int wt[] = new int[]{10, 15, 5, 1};
        int W = 30;
        int[] Ws = {1, 4, 5, 14, 15, 19, 20, 25, 30, 31, 32};
        int[] expected = {1, 1, 5, 11, 15, 16, 20, 25, 30, 31, 31};
        int[] res = new int[Ws.length];
        int n = val.length;
        System.out.println(knapSackIterativeWeight(W, wt));

        for (int i = 0; i < Ws.length; i++) {
            res[i] = knapSackIterativeWeight(Ws[i], wt);
        }
        Assert.assertArrayEquals(expected, res);
    }
}