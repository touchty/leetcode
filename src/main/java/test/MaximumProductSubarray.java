package test;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int max = nums[0];
        int min = nums[0];
        int res = max;
        for (int i = 1; i < nums.length; i++) {
            int tmax = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            int tmin = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            max = tmax;
            min = tmin;
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        MaximumProductSubarray solution = new MaximumProductSubarray();
        int max = solution.maxProduct(nums);
        System.out.println(max);
    }
}
