package HRQuestion.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Q111 {
    public static int FOO(String str) {
        int N = str.length();

        int modddd = 1_000_000_007;
        // dp[i][j] : Num ways to place P_i with relative rank j
        int[][] dp = new int[N+1][N+1];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i <= N; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (str.charAt(i-1) == '1') {
                    for (int k = j; k < i; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= modddd;
                    }
                } else {
                    for (int k = 0; k < j; ++k) {
                        dp[i][j] += dp[i-1][k];
                        dp[i][j] %= modddd;
                    }
                }
            }
        }

        int ans = 0;
        for (int x: dp[N]) {
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
            for (int i = 0; i < N-1; i++) {
                builder.append(scanner.nextInt());
            }
            String S = builder.toString();
            int res = FOO(S);
            System.out.println(res);
        }
    }
}
