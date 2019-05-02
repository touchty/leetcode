package test;

import org.junit.Assert;

public class LC153 {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] < nums[end])
                return nums[start];
            else {
                int mid = (start + end) / 2;
                if (nums[mid] > nums[start])
                    start = mid + 1;
                if (nums[mid] > nums[end])
                    start = mid + 1;
                else
                    end = mid;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;
        int res = LC153.findMin(nums);
        Assert.assertEquals(expected, res);
    }
}
