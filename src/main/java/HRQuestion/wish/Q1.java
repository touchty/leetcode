package HRQuestion.wish;

// 1 给定一个排好序的数字数组，以及其中一个数，求该数在数组中的位置的范围。

public class Q1 {
    static int[] range(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }

        // find first equal
        int left = 0;
        int right = nums.length - 1;
        int start = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target)
            start = left;

        // find last equal
        left = 0;
        right = nums.length - 1;
        int end = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;

            } else {
                right = mid - 1;
            }
        }
        if (right >= 0 && nums[right] == target)
            end = right;


        res[0] = start;
        res[1] = end;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 5, 6};
        int target = 3;
        int[] res = range(nums, target);
        System.out.println(res[0] + "-> " + res[1]);


        int[] nums_none = {1, 2, 3, 5};
        int target_none = 4;
        int[] res_none = range(nums_none, target_none);
        System.out.println(res_none[0] + "-> " + res_none[1]);

        int[] nums_all = {1,1,1,1};
        int target_all = 1;
        int[] res_all = range(nums_all, target_all);
        System.out.println(res_all[0] + "-> " + res_all[1]);
    }
}
