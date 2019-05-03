package test;

// 递归和动态规划算法
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if (invalid[i][j]) return false;
        if (k == c3.length) return true;
        if (i >= c1.length && j >= c2.length) return false;
        boolean valid =
                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if (!valid) invalid[i][j] = true;
        return valid;
    }

    // 没有记忆中间结果，性能差
    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k) {
        if (i > c1.length || j > c2.length) return false;
        if (k == c3.length) return true;
        boolean valid =
                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1) ||
                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1);
        return valid;
    }


    // dp
    public boolean isInterleaveDp(String s1, String s2, String s3) {

        if ((s1.length() + s2.length()) != s3.length()) return false;

        boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];

        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)))
                        || (matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return matrix[s2.length()][s1.length()];

    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        InterleavingString solution = new InterleavingString();
        boolean res = solution.isInterleaveDp(s1, s2, s3);
        System.out.println(res);
    }
}
