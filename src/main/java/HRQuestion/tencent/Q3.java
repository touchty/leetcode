package HRQuestion.tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    static int max = Integer.MIN_VALUE;
    static boolean canPartitioned = false;

    public static void canPartition(int[] nums) {
        max = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        /*if ((sum & 1) == 1) {
            return false;
        }*/
        sum /= 2;

        int n = nums.length;
        boolean[][][] dp = new boolean[n + 1][n + 1][sum + 1];
        dp[0][0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][0][0] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i && j <= (n + 1) / 2; j++) {
                for (int k = 1; k < sum + 1; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (k >= nums[i - 1]) {
                        dp[i][j][k] |= dp[i - 1][j - 1][k - nums[i - 1]];
                    }
                    if ((j == (n + 1) / 2 || j == n / 2) && dp[i][k][k]) {
                        max = Math.max(max, k);
                    }
                }

            }
        }
    }

    public static int[] foo(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        canPartition(nums);
        int[] res = new int[2];
        res[0] = max;
        res[1] = sum - max;
        Arrays.sort(res);
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            int[] res = foo(nums);
            System.out.println(res[0] + " " + res[1]);
        }
    }
}

/*
2
4
5 9 4 7
8
9 13 18 10 12 4 18 3
 */