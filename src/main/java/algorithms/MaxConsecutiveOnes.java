package algorithms;

/*
485. Max Consecutive Ones
Easy

349

302

Favorite

Share
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currLenOnes = 0;
        for (int i : nums) {
            if (i == 1) currLenOnes++;
            else currLenOnes = 0;
            max = Math.max(max, currLenOnes);
        }
        return max;
    }

    /*
    // Sliding window
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < nums.length) {
            if (nums[j] == 1){
                max = Math.max(j - i + 1, max);
                j++;
            }
            else {
                j++;
                i = j;
            }
        }
        return max;
    }
     */
}
