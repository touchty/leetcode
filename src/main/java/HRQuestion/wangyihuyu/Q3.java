package HRQuestion.wangyihuyu;

import java.util.Scanner;

public class Q3 {
    // Returns the maximum value that can be put in a knapsack of capacity W
    static double knapSackIterative(int W, int wt[], double val[], int n) {

        // dp[i][j] stores the maximum value when there are i element and the
        // knapstack is j
        double[][] dp = new double[n + 1][W + 1];
        dp[0][0] = 0;
        double MAX = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * case1: 带上第i个元素，获得收益val[i] case2: 不带上第i个元素
                     */
                    double val1 = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    double val2 = dp[i - 1][j];

                    dp[i][j] = Math.max(val1, val2);
                }
                MAX = Math.max(MAX, dp[i][j]);
            }
        }

        return MAX;
    }

    // Driver program to test above function
    public static void main(String args[]) {
        /*int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 51;
        int n = val.length;
        System.out.println(knapSackIterative(W, wt, val, n));*/

        /*int val[] = new int[]{10, 15, 5};
        int wt[] = new int[]{10, 15, 5, 1};
        int W = 30;
        int[] Ws = {1, 4, 5, 14, 15, 19, 20, 25, 30, 31, 32};
        int[] expected = {1, 1, 5, 11, 15, 16, 20, 25, 30, 31, 31};
        int[] res = new int[Ws.length];
        int n = val.length;
        System.out.println(knapSackIterativeWeight(W, wt));

        for (int i = 0; i < Ws.length; i++) {
            res[i] = knapSackIterativeWeight(Ws[i], wt);
        }*/

        Scanner scanner = new Scanner(System.in);
        int W = scanner.nextInt();
        int n = scanner.nextInt();
        int[] wt = new int[n];
        double[] val = new double[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] ss = line.split(",");
            wt[i] = Integer.valueOf(ss[0]);
            val[i] = Double.valueOf(ss[1]) * wt[i];
        }
        double res = knapSackIterative(W, wt, val, n);
        System.out.printf("%.4f", res);
    }
}
