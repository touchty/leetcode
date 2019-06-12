package test;

import java.util.Arrays;
// 最长递增子串

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1)
            return nums.length;
        int max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public static int lengthOfLIS_BS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int maxLen = solution.lengthOfLIS_BS(nums);
        System.out.println(maxLen);
    }
}