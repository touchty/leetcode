package test;

import java.util.Arrays;

// LC 416. Partition Equal Subset Sum
// 分割数组，两部分和相等
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int N = nums.length;
        for (int n : nums)
            sum += n;

        if (sum % 2 == 1) return false;

        return helper(nums, sum / 2);
    }

    boolean helper(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }

        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= j) {
                    /*System.out.println("==========");
                    System.out.println(i);
                    System.out.println(j);*/
                    dp[i + 1][j] = dp[i][j] || dp[i][j - nums[i]];
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        boolean partioning = solution.canPartition(nums);

        System.out.println(partioning);
    }
}
