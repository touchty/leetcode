package ZJTD;

import java.util.Scanner;

public class Main2 {
    static int roads(int p) {
        int mod = 1000000007;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        dp[2] = 1;
        if (p <= 2)
            return dp[p];
        for (int i = 4; i <= p; i++) {
//            dp[i] = (i - 1) * dp[i - 2] * dp[i - 2];
            for (int j = 2; j <= i; j += 2) {
                dp[i] += dp[i - j] * dp[j - 2];
                dp[i] = dp[i] % mod;
            }
        }
        return dp[p];
    }

    public static void main(String[] args) {
        /*int p = 6;
        int res = roads(p);
        System.out.println(res);*/

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();

            int cs = roads(m);
            System.out.println(cs);
        }
    }
}
