package test;

public class LC10RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
                    dp[i + 1][j + 1] = dp[i][j];

                else if (j > 0 && p.charAt(j) == '*') {
                    dp[i + 1][j + 1] |= dp[i + 1][j - 1]; // empty
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] |= dp[i][j - 1];
                        dp[i + 1][j + 1] |= dp[i][j + 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String[] ss = {"mississippi"};
        String[] ps = {"mis*is*p*."};
        boolean[] res = new boolean[ss.length];
        res[0] = isMatch(ss[0], ps[0]);
        System.out.println(res[0]);
    }
}
