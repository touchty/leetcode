package dp;

public class BestTimetoBuyandSellStock {

    /*
     * rest has no effection on the profit
     *
     * buy at pos i or do nothing at pos i (rest at i)
     * buy[i] = max(sell[i-2]-price, buy[i-1])
     *
     * sell at pos i or do nothing (rest at i)
     * sell[i] = max(buy[i-1]+price, sell[i-1])
     * */

    public int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}
