package dp;

public class BestTimetoBuyandSellStockwithTransactionFee {
    /*
    *
FLAGbigoffer
FLAGbigoffer
 43
Last Edit: Apr 2, 2018, 5:38 AM

Define dp array:
hold[i] : The maximum profit of holding stock until day i;
notHold[i] : The maximum profit of not hold stock until day i;

dp transition function:
For day i, we have two situations:

Hold stock:
(1) We do nothing on day i: hold[i - 1];
(2) We buy stock on day i: notHold[i - 1] - prices[i];

Not hold stock:
(1) We do nothing on day i: notHold[i - 1];
(2) We sell stock on day i: hold[i - 1] + prices[i] - fee;
    * */

    public int maxProfit_ON(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int[] hold = new int[len];     //Till day i, the max profit is hold[i] if I hold the stock.
        int[] notHold = new int[len];  //Till day i, the max profit is notHold[i] if I do not hold the stock.

        hold[0] = -prices[0];
        notHold[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] - fee + prices[i]);
        }

        return notHold[len - 1];
    }

    public int maxProfit_O1(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int hold = -prices[0];
        int notHold = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i] - fee);
        }

        return notHold;
    }

    public int maxProfit_buyingFee(int[] prices, int fee) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
        }

        return T_ik0;
    }

    public int maxProfit_sellingFee(int[] prices, int fee) {
        long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            long T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return (int)T_ik0;
    }
}
