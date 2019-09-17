public class LongestPalindromicSubstring {
    // LC 5. Longest Palindromic Substring
    // 最长回文子串， 动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int start = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j]) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }

                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
