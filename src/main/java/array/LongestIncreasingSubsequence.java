package array;

import org.junit.Assert;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
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
        int[] nums = new int[]{3,5,4,2,7,9};
        int result = LongestIncreasingSubsequence.lengthOfLIS(nums);
        int expected = 4;
        Assert.assertEquals(result, expected);
    }
}
