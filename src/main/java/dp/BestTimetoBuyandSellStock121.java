package dp;

public class BestTimetoBuyandSellStock121 {
    /*
* All the straight forward solution should work,
* but if the interviewer twists the question slightly
* by giving the difference array of prices,
* Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7},
* you might end up being confused.
Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
* */
    int maxProfit(int[] nums) {
        int maxCur = 0;
        int maxSoFar = 0;

        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(0, maxCur += nums[i] - nums[i - 1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
