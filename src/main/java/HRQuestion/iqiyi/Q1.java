package HRQuestion.iqiyi;

import java.util.Scanner;

// LC 903. Valid Permutations for DI Sequence
// 排列计数
// https://leetcode.com/problems/valid-permutations-for-di-sequence/discuss/196939/Easy-to-understand-solution-with-detailed-explanation

/*
解题思路：
With the example above in mind, the transition function seems to be clear.

Given a string DI-seq S, let dp[i][j] represents the number of permutation of number 0, 1, ... , i, satisfying DI-rule S.substr(0, i), and ending with digit j.

if(S[i-1] == 'D') // 把已有的排列中大于等于j的元素都加1，然后在尾部拼接j
   dp[i][j] = dp[i-1][j] + dp[i-1][j+1] + ... + dp[i-1][i-1]

if(S[i-1] == 'I')
   dp[i][j] = dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j-1]
 */
public class Q1 {
    public static int FOO(String str) {
        int N = str.length();

        int modddd = 1_000_000_007;
        // dp[i][j] : Num ways to place P_i with relative rank j
        int[][] dp = new int[N + 1][N + 1];

        //Arrays.fill(dp[0], 1);
        dp[0][0] = 1;

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (str.charAt(i - 1) == '1') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= modddd;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= modddd;
                    }
                }
            }
        }

        int ans = 0;
        for (int x : dp[N]) {
            ans += x;
            ans %= modddd;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            for (int i = 0; i < N - 1; i++) {
                builder.append(scanner.nextInt());
            }
            String S = builder.toString();
            int res = FOO(S);
            System.out.println(res);
        }
    }
}
