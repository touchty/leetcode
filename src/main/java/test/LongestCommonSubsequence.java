package test;

import org.junit.Assert;

// 1143. Longest Common Subsequence
// 最长公共子序列，(不连续)
public class LongestCommonSubsequence {
    public static int getLongestCommonSubsequence(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    //dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + 1);
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    // 空间优化
    // 翻转数组
    // https://leetcode.com/problems/longest-common-subsequence/discuss/351689/Java-Two-DP-codes-of-O(mn)-and-O(min(m-n))-spaces-w-picture-and-analysis
    public static int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[2][n + 1];
        for (int i = 0, k = 1; i < m; ++i, k ^= 1) // 此处翻转数组
            for (int j = 0; j < n; ++j)
                if (s1.charAt(i) == s2.charAt(j)) dp[k][j + 1] = 1 + dp[k ^ 1][j];
                else dp[k][j + 1] = Math.max(dp[k ^ 1][j + 1], dp[k][j]);
        return dp[m % 2][n]; // 假设只有一行，应该返回dp[1][n]，因为进入了循环，且结果存储在dp[1]中
    }

    /*public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < n)
            return longestCommonSubsequence(text2, text1);
        // 翻转数组
        int[][] dp = new int[2][n + 1];
        for (int i = 0, k = 1; i < m; i++, k = 1 - k) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[k][j + 1] = dp[1 - k][j] + 1;
                } else {
                    dp[k][j + 1] = Math.max(dp[1 - k][j + 1], dp[k][j]);
                }
            }
        }

        return dp[m % 2][n];
    }*/

    public static void main(String[] args) {
        String a = "abcd";
        String b = "adbccbda";
        int lcsubsequenceLen = LongestCommonSubsequence.getLongestCommonSubsequence(a, b);
        int lcsubsequenceLen1 = LongestCommonSubsequence.longestCommonSubsequence(a, b);
        int expected = 4;
        Assert.assertEquals(expected, lcsubsequenceLen);
        System.out.println(lcsubsequenceLen);
        System.out.println(lcsubsequenceLen1);
    }
}
