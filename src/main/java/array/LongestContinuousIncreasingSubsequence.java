package array;

/*
674. Longest Continuous Increasing Subsequence
Easy

417

91

Favorite

Share
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
Note: Length of the array will not exceed 10,000.
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] diffs = new int[nums.length];
        diffs[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            diffs[i] = nums[i] - nums[i - 1];
        }

        // sliding window
        int i = 0;
        int j = 0;
        int res = 0;
        while (j < diffs.length) {
            if (diffs[j] <= 0) {
                res = Math.max(res, j - i);
                i = j;
            }
            j++;
        }
        if (diffs[diffs.length - 1] > 0) {
            res = Math.max(res, j - i);
        }
        return res;
    }

    public int findLengthOfLCISOpt(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, len = 1, res = 1;
        while (i < nums.length - 1) {
            if (nums[i] < nums[i + 1]) {
                len++;
                i++;
            } else {
                res = Math.max(len, res);
                len = 1;
                i++;
            }
        }
        res = Math.max(res, len);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2, 3, 4};
        LongestContinuousIncreasingSubsequence solution =
                new LongestContinuousIncreasingSubsequence();
        int length = solution.findLengthOfLCISOpt(nums);
        System.out.println(length);
    }
}
