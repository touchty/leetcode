package algorithms;

public class Kadane {
    public static int maxSumOfSubarray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = Integer.MIN_VALUE;

        max_ending_here = nums[0];
        max_so_far = nums[0];
        for (int i = 1; i < len; i++) {
            max_ending_here = Math.max(nums[i], nums[i] + max_ending_here);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, -1, 0, 10};
        int res = maxSumOfSubarray(nums);
        System.out.println(res);

        nums = new int[]{0, -1, -5, 0, -4};
        res = maxSumOfSubarray(nums);
        System.out.println(res);
    }
}
