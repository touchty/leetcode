package test;

public class LC44WildcardMatching {
    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        //初始化要考虑s长度为0的情况
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*')
                break;
            dp[0][i + 1] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                // 相等
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                // pattern at i-th index is '*'
                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1];
                    //                    1              empty       multi
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        boolean matched = isMatch(s, p);
        System.out.println(matched);
    }
}
