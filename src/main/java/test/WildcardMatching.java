package test;

// 跟正则表达式类似， 稍有区别
// * 匹配一个或者多个任意字符， 跟*之前的字符无关
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') {
                    /*// none
                    dp[i][j] = dp[i][j - 1];
                    //single
                    dp[i][j] =dp[i][j] || dp[i-1][j-1];
                    // multi
                    dp[i][j] = dp[i][j] || dp[i-1][j];*/

                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String[] s = {"aa", "aa", "cb", "ab", "ab"};
        String[] p = {"a", "*", "?a", "ab", "a*"};
        boolean[] res = new boolean[s.length];
        for (int i = 0; i < s.length; i++) {
            res[i] = WildcardMatching.isMatch(s[i], p[i]);
            System.out.println(res[i]);
        }
    }
}
