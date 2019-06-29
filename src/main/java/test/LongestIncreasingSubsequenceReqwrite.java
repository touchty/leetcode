package test;

import java.util.Arrays;

public class LongestIncreasingSubsequenceReqwrite {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        // Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    // nlogn
    // dp[maxLen - 1] 长度为maxLen的子串的最小结尾
    // dp[0] = nums[0]
    // 如果nums[1] < nums[0], nums[1] 更小，所以dp[0]可以被更新成nums[1]
    // 如果nums[1] > nums[0], nums[1] 更大，所以dp[0]不可以被更新成nums[1]，
    // 且子串可以被拓展，dp[maxLen] = nums[1], 更新maxLen++
    public int lengthOfLISOpt(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        // Arrays.fill(dp, 1);
        int maxLen = 1;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[maxLen - 1]) {
                dp[maxLen] = nums[i];
                maxLen++;
            } else {
                int pos = Arrays.binarySearch(dp, 0, maxLen, nums[i]);
                if (pos < 0) {
                    pos = -pos - 1;
                    dp[pos] = nums[i];
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        LongestIncreasingSubsequenceReqwrite solution = new LongestIncreasingSubsequenceReqwrite();
        int lis = solution.lengthOfLISOpt(nums);
        System.out.println(lis);
    }
}
