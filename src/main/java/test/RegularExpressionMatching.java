package test;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && i >= 2 && dp[0][i - 2] == true)
                dp[0][i] = true;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = (dp[i][j - 1]); // single
                    if (j >= 2 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'))
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // multi
                    if (j >= 2) {
                        dp[i][j] = dp[i][j] || dp[i][j - 2];// none
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "a*bc";
        boolean res = RegularExpressionMatching.isMatch(a, b);
        System.out.println(res);
    }
}
