package test;

// LC 718. Maximum Length of Repeated Subarray
// 最长公共子串，连续
public class LCS {
    static String lcs(String str1, String str2) {
        if (str1 == null || str1.length() == 0 ||
                str2 == null || str2.length() == 0) {
            return null;
        }


        int endOfFirstStr = 0;
        int maxLen = 0;
        int[][] dp = new int[str1.length()+ 1][str2.length() + 1];

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    if (dp[i+1][j+1] > maxLen) {
                        maxLen = dp[i+1][j+1];
                        endOfFirstStr = i;
                    }
                }
            }
        }

        String s = str1.substring(endOfFirstStr - maxLen + 1, endOfFirstStr + 1);
        return s;
    }


    public static void main(String[] args) {
        String str1 = "akbabcs";
        String str2 = "bammbpivabc";

        String lcs = LCS.lcs(str1, str2);
        System.out.println(lcs.length());
    }
}
