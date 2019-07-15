package test;

// 673. Number of Longest Increasing Subsequence
public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int[] counts = new int[nums.length];
        int[] lens = new int[nums.length];
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            lens[i] = 1;
            counts[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (lens[i] == lens[j] + 1)
                        counts[i] += counts[j];
                    if (lens[i] < lens[j] + 1) {
                        lens[i] = lens[j] + 1;
                        counts[i] = counts[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lens[i]);
        }

        int totalCounts = 0;
        for (int i = 0; i < counts.length; i++) {
            if (lens[i] == maxLen) {
                totalCounts += counts[i];
            }
        }
        return totalCounts;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        NumberofLongestIncreasingSubsequence subsequence = new NumberofLongestIncreasingSubsequence();
        int totalCount = subsequence.findNumberOfLIS(nums);
        System.out.println(totalCount);
    }
}
