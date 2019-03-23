package dp;

public class DecodeWays {
    /*
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     *
     * 12
     *
     *
     * */

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;

        for (int i = 2; i < len + 1; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int val = Integer.valueOf(s.substring(i - 2, i));
            if (val >= 10 && val <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }

    public int numDecodingsRewrite(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0') dp[1] = 1;

        for (int i = 2; i < len + 1; i++) {
            if (s.charAt(i - 1) != '0')
                dp[i] += dp[i - 1];
            int val = Integer.valueOf(s.substring(i - 2, i));
            if (val >= 10 && val <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[len];
    }

    public int numDecodingsRewrite2(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

        return memo[0];
    }

}
