package offer;

public class O3DuplicateNumber {
    public static boolean duplicate(int[] nums, int[] duplication) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5};
        int[] dup = {-1};
        boolean isDup = O3DuplicateNumber.duplicate(nums, dup);
        System.out.println(isDup);
        System.out.println(dup[0]);
    }
}
