package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        /*
        * dp[i] is the minimum value a subsequence of length i+1 might end with.
        * case 1 : 1,2,3,4,5
        * len can increase,cause 1 < 2, 2 < 3
        *
        *
        * case 2 : 1,2,4,3,5
        * 1==>len=1, 2==>len=2, 4==>len=3, but 3=/=>len++ because 3 < 4
        * then update dp[2] = 3.
        * we don't need 4 any more cause wecan always use 3 instead of 4.
        * */

        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {

            //  search dp not nums,
            //  0 <= i <= len
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);  //  x is not in dp[0,.....,len - 1]
            dp[i] = x;  //  x is not in dp or within  dp[0, ....., len - 1]

            //  append x to dp[i], and increase the length of the subsequence
            //  because x is greater than dp[i - 1]
            if (i == len) len++;
        }

        return len;
    }

    public int lengthOfLISRewrite(int[] nums) {
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
}
