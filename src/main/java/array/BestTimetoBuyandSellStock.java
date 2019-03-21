package array;

import org.junit.Assert;

/*
121. Best Time to Buy and Sell Stock
Easy

2290

114

Favorite

Share
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class BestTimetoBuyandSellStock {

    /**
     * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned this so far, I thought it's a good thing for everybody to know.
     * <p>
     * All the straight forward solution should work, but if the interviewer twists the question slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.
     * <p>
     * Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i - 1]); // sale at ith day, and buy at a certain previous
            // day.
            maxSoFar = Math.max(maxCur, maxSoFar); // max profit of profits selling at a certain day.
        }
        return maxSoFar;
    }


    public int maxProfitOpt(int[] prices) {
        if (prices.length < 2)
            return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimetoBuyandSellStock solution = new BestTimetoBuyandSellStock();
        int maxProfit = solution.maxProfitOpt(prices);
        int expected = 5;
        Assert.assertEquals(expected, maxProfit);
    }
}
