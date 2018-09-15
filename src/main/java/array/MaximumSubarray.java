package array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;

        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
