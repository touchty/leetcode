package sort;

import java.util.Arrays;

/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.
*/

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        int[] copy = new int[nums.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) copy[i] = nums[i];

        // larger numbers in odd positions
        int index = 1;
        for (int i = nums.length - 1; i > (nums.length - 1) / 2; i--) {
            nums[index] = copy[i];
            index += 2;
        }

        // less numbers in even positions
        index = 0;
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            nums[index] = copy[i];
            index += 2;
        }
    }
}
