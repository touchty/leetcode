package HRQuestion.shopee;

import java.util.Arrays;
import java.util.Scanner;


public class O2 {
    public static int coinChange(int[] coins, int amount) {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] coins = {1, 2, 4, 5, 10, 20};
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int t = in.nextInt();
            int res = coinChange(coins, t);
            System.out.println(res);
        }
        //System.out.println(coinChange(coins, 8));
    }
}
