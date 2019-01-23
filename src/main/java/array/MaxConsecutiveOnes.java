package array;

/**
 * 485. Max Consecutive Ones
 * Easy
 * <p>
 * 312
 * <p>
 * 287
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int MAX = 0;
        if (nums.length == 0) {
            return MAX;
        }
        int prev = nums[0];
        int i = 0;
        int temp = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                temp++;
            } else {
                MAX = Math.max(MAX, temp);
                temp = 0;
            }
            i++;
        }
        // in case the tail is one, for example, nums = [110111]
        // temp is 3, and MAX has to be updated!
        MAX = Math.max(MAX, temp);
        return MAX;
    }
}
