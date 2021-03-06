package dp;

import java.util.Arrays;

// LC 300. Longest Increasing Subsequence
// 最长递增子序列
public class LongestIncreasingSubsequence {
    /*
     * dp[i] is the minimum value a subsequence of length i+1 might end with.
     * case 1 : 1,2,3,4,5
     * len can increase,cause 1 < 2, 2 < 3
     *
     * case 2 : 1,2,4,3,5
     * 1==>len=1, 2==>len=2, 4==>len=3, but 3=/=>len++ because 3 < 4
     * then update dp[2] = 3.
     * we don't need 4 any more cause wecan always use 3 instead of 4.
     * */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0)
                i = -(i + 1);
            dp[i] = x;

            if (i == len)
                len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int len = solution.lengthOfLIS(nums);
        System.out.println(len);
    }

}
