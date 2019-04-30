package test;

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currentMax = 0;

        for (int i : nums) {
            currentMax = Math.max(i, currentMax + i);
            max = Math.max(currentMax, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = MaximumSubarray.maxSubArray(nums);
        System.out.println(max);
    }
}
