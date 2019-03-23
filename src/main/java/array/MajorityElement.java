package array;

import java.util.Arrays;

/**
 * 169. Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int half = n / 2;

        for (int i = 0; i <= half && i + half < n; i++) {
            if (nums[i] == nums[i + half])
                return nums[i];
        }
        return 0;
    }
}
