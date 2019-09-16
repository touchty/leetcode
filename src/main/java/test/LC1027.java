package test;

import java.util.HashMap;

// LC 1027. Longest Arithmetic Sequence
// 最长的等差数列
public class LC1027 {
    public static int longestArithSeqLength(int[] A) {
        int res = 0, n = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < A.length; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int d = A[j] - A[i];
                dp[j].put(d, dp[i].getOrDefault(d, 1) + 1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {9, 4, 7, 2, 10};
        int longest = longestArithSeqLength(A);
        System.out.println(longest);
    }
}
