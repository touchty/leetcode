package test;

import java.util.Arrays;

// LC 416. Partition Equal Subset Sum
// 分割数组，两部分和相等
// 0/1 knapsack detailed explanation
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
                    dp[i + 1][j] = dp[i][j] || dp[i][j - nums[i]];
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        return dp[nums.length][target];
    }

    public boolean canPartitionRewrite(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        sum /= 2;

        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[j + 1][i] = dp[j][i] || dp[j][i - nums[j]];
                } else {
                    dp[j + 1][i] = dp[j][i];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public boolean canPartition1D(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        PartitionEqualSubsetSum solution = new PartitionEqualSubsetSum();

        boolean partioning = solution.canPartition1D(nums);

        System.out.println(partioning);
    }
}
