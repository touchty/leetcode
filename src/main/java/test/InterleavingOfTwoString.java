package test;

// 两个字符串的并，相对顺序不变
public class InterleavingOfTwoString {
    boolean isInterleaving(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean isTrue = dfs(s1, 0, s2, 0, s3, 0);
        return isTrue;
    }

    private boolean dfs(String s1, int p1, String s2, int p2, String s3, int p3) {
        if (p3 > s3.length())
            return false;
        // find interleaving!
        if (p3 == s3.length()) {
            return true;
        }

        boolean res = false;
        if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
            res |= dfs(s1, p1 + 1, s2, p2, s3, p3 + 1);
        }
        if (!res && p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
            res |= dfs(s1, p1, s2, p2 + 1, s3, p3 + 1);
        }
        return res;
    }


    boolean isInterleavingDp(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s3.charAt(i))
                dp[i + 1][0] = true;
            else
                break;
        }

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s3.charAt(i))
                dp[0][i + 1] = true;
            else
                break;
        }
        // 注意长度
        // 0...i s1
        // 0...j s2
        // 0...(i+j+1) s3
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s3.charAt(i + j + 1) == s1.charAt(i))
                    dp[i + 1][j + 1] |= dp[i][j + 1];
                if (s3.charAt(i + j + 1) == s2.charAt(j))
                    dp[i + 1][j + 1] |= dp[i + 1][j];
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        /*String s1 = "ab";
        String s2 = "cd";
        String s3 = "acbd";*/
        /*
         * aa
         * aa
         * aaaa
         * 2 ^(m+n)
         * */

        /*
         * dp
         * (s1, s2) (i, j)
         *
         *  s3(i+j+1), (i+1, j)
         *  s3(i+j+1), (i, j+1)
         * */

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";

        InterleavingOfTwoString solution = new InterleavingOfTwoString();
        boolean res = solution.isInterleavingDp(s1, s2, s3);
        System.out.println(res);
    }
}
