package array;

import java.util.HashMap;
import java.util.Map;

/*
525. Contiguous Array
Medium

618

28

Favorite

Share
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
 */

/*
Solution:
The idea is to change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0 then we know there are even number
of -1 and 1 between index i and j. Also put the sum to index mapping to a HashMap to make search faster.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            // turn 0 to -1. so the array becomes a sequence of -1 and 1
            sum += 2 * nums[i] - 1;
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }
}
