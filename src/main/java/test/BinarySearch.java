package test;

public class BinarySearch {
    /**
     * 最后一个小于目标的下标
     *
     * @param nums
     * @param target
     * @return
     */
    static int low(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target)
                right = mid - 1;
            else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 第一个大于目标的小标
     *
     * @param nums
     * @param target
     * @return
     */
    static int upper(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target)
                right = mid - 1;
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 4, 4, 5, 7};
        int target = 4;
        System.out.println(low(nums, target));
        System.out.println(upper(nums, target));
    }
}
