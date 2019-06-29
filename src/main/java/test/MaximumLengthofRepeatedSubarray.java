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

    public int findLength1D(int[] A, int[] B) {
        // dp[i][j]: A(i-1) 和 B(j-1)结尾的子串
        // dp[i][j] is the length of longest common subarray ending with A[i-1] and B[j-1]
        int[] dp = new int[A.length + 1];
        int max = 0;
        for (int i = 0; i < B.length; i++) {
            for (int j = A.length - 1; j >= 0; j--) {
                if (A[j] == B[i]) {
                    dp[j + 1] = dp[j] + 1;// 连续，拼接前面的子串
                    max = Math.max(max, dp[j + 1]);
                } else {
                    dp[j + 1] = 0;
                    // 与2D不同之处：2D有初始值0，如果没有更新则为0，而1D如果不更新则保持原来的值
                    /*
                    　　 b　　a　　b

                        c　　0　　0　　0

                        a　　0　　1　　0

                        b　　1　　0　　2

                        a　　0　　2　　0
                     */
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1};
        int[] B = {2, 0, 1, 0};
        MaximumLengthofRepeatedSubarray solution = new MaximumLengthofRepeatedSubarray();
        int length = solution.findLength(A, B);
        int length1D = solution.findLength1D(A, B);
        System.out.println(length == length1D);
    }
}
