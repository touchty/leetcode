package test;
// 0-1 背包问题
// 注意这里每个元素只能用一次
public class Knapsack {
    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSackRecursive(int W, int wt[], int val[], int n) {
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < wt.length; j++) {
                if (wt[j] <= i) {
                    dp[j+1][i] = Math.max(dp[j][i], dp[j][i - wt[j]] + val[j]);
                }else {
                    dp[j+1][i] = dp[j][i];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 51;
        int n = val.length;
        int maxVal = Knapsack.knapSackRecursive(W, wt, val, n);
        System.out.println(maxVal);
    }
}
