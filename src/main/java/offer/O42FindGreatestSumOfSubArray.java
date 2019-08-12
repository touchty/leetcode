package offer;

public class O42FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int n : nums) {
            sum = sum >= 0 ? sum + n : n;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {6, -3, -2, 7, -15, 1, 2, 2};
        O42FindGreatestSumOfSubArray solution = new O42FindGreatestSumOfSubArray();
        int maxSum = solution.FindGreatestSumOfSubArray(nums);
        System.out.println(maxSum);
    }
}
