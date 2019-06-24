package test;

// 718. Maximum Length of Repeated Subarray
// 数组最大公共子串，连续的情况！
public class MaximumLengthofRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
        // dp[i][j]: A(i-1) 和 B(j-1)结尾的子串
        // dp[i][j] is the length of longest common subarray ending with A[i-1] and B[j-1]
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;// 连续，拼接前面的子串
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max;
    }
}
