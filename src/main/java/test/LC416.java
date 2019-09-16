package test;

import java.util.Arrays;
import java.util.Scanner;

public class LC416 {
    static int max = Integer.MIN_VALUE;

    public static boolean canPartition(int[] nums) {
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
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
                }
                if (dp[i][j]) {
                    max = Math.max(max, j);
                }
            }
        }
        return dp[n][sum];
    }

    public static int minDiff(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        canPartition(nums);
        return Math.abs(max - (sum - max));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(minDiff(nums));
        }
    }
}
