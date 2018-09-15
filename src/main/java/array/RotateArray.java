package array;

public class RotateArray {
    public void rotate_v1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[(i - k + n) % n];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }

    public void rotate_v2(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        int[] tempArray = new int[k];
        for (int i = n - k; i < n; i++) {
            tempArray[i - (n - k)] = nums[i];
        }
        for (int i = k; i < n; i++) {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++) {
            nums[i] = tempArray[i];
        }
    }

    public void rotate_v3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
