package dp;

public class DominoandTrominoTiling790 {
    private static int MOD = 1_000_000_007;

    public int numTilings(int N) {
        int t_prepre = 1;
        int t_pre = 1;

        int t_up_pre = 0;
        int t_down_pre = 0;

        for (int i = 2; i <= N; i++) {
            // memorize current states
            int t_curr = (int) (0L + t_pre + t_prepre + t_down_pre + t_up_pre) % MOD;
            int t_up_curr = t_down_pre + t_prepre % MOD;
            int t_down_curr = t_up_pre + t_prepre % MOD;

            t_prepre = t_pre;
            t_pre = t_curr;
            t_up_pre = t_up_curr;
            t_down_pre = t_down_curr;

        }
        return t_pre;
    }

    public int numTilingsSimplicity(int N) {
        int p3 = -1, p2 = 0, p1 = 1;

        for (int n = 1; n <= N; n++) {
            int cur = (int) ((p1 * 2L + p3) % MOD);
            p3 = p2;
            p2 = p1;
            p1 = cur;
        }

        return p1;
    }

/*

dp[n]=dp[n-1]+dp[n-2]+ 2*(dp[n-3]+…+d[0])
=dp[n-1]+dp[n-2]+dp[n-3]+dp[n-3]+2*(dp[n-4]+…+d[0])
=dp[n-1]+dp[n-3]+(dp[n-2]+dp[n-3]+2*(dp[n-4]+…+d[0]))
=dp[n-1]+dp[n-3]+dp[n-1]
=2*dp[n-1]+dp[n-3]
* */
}
