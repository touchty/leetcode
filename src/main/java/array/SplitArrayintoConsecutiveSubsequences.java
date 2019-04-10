package array;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/*
659. Split Array into Consecutive Subsequences
Medium

485

206

Favorite

Share
You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences :
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
Note:
The length of the input is in range of [1, 10000]
 */


public class SplitArrayintoConsecutiveSubsequences {

    /*
    https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/106496/Java-O(n)-Time-O(n)-Space
    We iterate through the array once to get the frequency of all the elements in the array
    We iterate through the array once more and for each element we either see if it can be appended to a previously
    constructed consecutive sequence or if it can be the start of a new consecutive sequence. If neither are true, then we return false.
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0) continue;
            // APPEND TO PREVIOUS SUBARRAY
            else if (appendfreq.getOrDefault(i, 0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i + 1, appendfreq.getOrDefault(i + 1, 0) + 1);
            }
            // SERVE AS A LEADING ELEMENT
            else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                appendfreq.put(i + 3, appendfreq.getOrDefault(i + 3, 0) + 1);
            } else return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 3, 4, 5}, {1, 2, 3, 3, 4}};
        SplitArrayintoConsecutiveSubsequences s
                = new SplitArrayintoConsecutiveSubsequences();
        boolean[] res = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = s.isPossible(nums[i]);
        }
        boolean[] expected = {true, false};
        Assert.assertArrayEquals(expected, res);
    }
}
