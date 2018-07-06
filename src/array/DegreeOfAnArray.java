package array;

import java.util.*;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.* Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.*
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int degree = 0, result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            if (map.get(nums[i]).size() > degree) degree++;
        }
        for (List<Integer> range : map.values()) {
            if (range.size() == degree) {
                int left = range.get(0);
                int right = range.get(range.size() - 1);
                result = Math.min(result, right - left + 1);
            }
        }
        return result;
    }
}
