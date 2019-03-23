package array;

/**
 * 724. Find Pivot Index
 * <p>
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * <p>
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * <p>
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] sums = new int[nums.length + 1];
        // -1 to nums.length - 1
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int res = -1;
        for (int i = 0; i < sums.length - 1; i++) {
            if (sums[i] == sums[sums.length - 1] - sums[i + 1])
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        //int[] nums = {1, 7, 3, 6, 5, 6};
        //int[] nums = {1};
        int[] nums = {1, 2, 3};
        int res = new FindPivotIndex().pivotIndex(nums);
        System.out.println(res);
    }
}
