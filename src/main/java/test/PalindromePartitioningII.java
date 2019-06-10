package test;

// LC 132 Palindrome Partitioning II
// 动态规划x2， 两个动态规划数组，一个用来计算是否是回文数组，
// 另一个用来确定最小回文切割数
/*
This can be solved by two points:

cut[i] is the minimum of cut[j - 1] + 1 (j <= i), if [j, i] is palindrome.
If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
The 2nd point reminds us of using dp (caching).
 */
public class PalindromePartitioningII {
    int min = Integer.MAX_VALUE;

    public int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }

    public static void main(String[] args) {
        String s = "ab";
        PalindromePartitioningII solution = new PalindromePartitioningII();
        int min = solution.minCut(s);
        System.out.println(min);
    }
}
