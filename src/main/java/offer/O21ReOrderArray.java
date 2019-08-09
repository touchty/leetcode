package offer;

public class O21ReOrderArray {
    public void reOrderArray(int[] nums) {
        int N = nums.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(nums[j]) && !isEven(nums[j + 1])) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private boolean isEven(int x) {
        return x % 2 == 0;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        O21ReOrderArray solution = new O21ReOrderArray();
        solution.reOrderArray(nums);
        for (int t : nums)
            System.out.println(t);
    }
}
