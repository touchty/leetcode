package dp;

public class Knapsack1D {
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSackIterative(int W, int wt[], int val[], int n) {

        // dp[i][j] stores the maximum value when there are i element and the
        // knapstack is j
        int[] dp = new int[W + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    continue;
                } else {
                    /*
                     * case1: 带上第i个元素，获得收益val[i] case2: 不带上第i个元素
                     */
                    int val1 = val[i - 1] + dp[j - wt[i - 1]];
                    int val2 = dp[j];

                    dp[j] = Math.max(val1, val2);
                }
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int val[] = new int[]{10, 15, 5};
        int wt[] = new int[]{10, 15, 5};
        int W = 21;
        int[] Ws = {1, 4, 5, 14, 15, 19, 20, 25, 30, 31, 32};
        int[] expected = {1, 1, 5, 11, 15, 16, 20, 25, 30, 31, 31};
        int[] res = new int[Ws.length];
        int n = val.length;
        System.out.println(knapSackIterative(W, wt, val, 3));
    }
}
