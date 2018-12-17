package dp;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 956. Tallest Billboard
 * You are installing a billboard and want it to have the largest height.  The billboard will have two steel supports, one on each side.  Each steel support must be an equal height.
 *
 * You have a collection of rods which can be welded together.  For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
 *
 * Return the largest possible height of your billboard installation.  If you cannot support the billboard, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,6]
 * Output: 6
 * Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
 * Example 2:
 *
 * Input: [1,2,3,4,5,6]
 * Output: 10
 * Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
 * Example 3:
 *
 * Input: [1,2]
 * Output: 0
 * Explanation: The billboard cannot be supported, so we return 0.
 *
 *
 * Note:
 *
 * 0 <= rods.length <= 20
 * 1 <= rods[i] <= 1000
 * The sum of rods is at most 5000.
 */

/*
Solution:
Explanation:

dp[d] mean the maximum pair of sum we can get with pair difference d

For example, if have a pair of sum (a, b) with a > b, then dp[a - b] = b

If we have dp[diff] = a, it means we have a pair of sum (a, a + diff).

And this is the biggest pair with difference = a

Time Complexity:
O(NM), where we have
N = rod.length <= 20
S = sum(rods) <= 5000
M = all possible sum = min(3^N, S)

There are 3 ways to arrange a number: in the first group, in the second, not used.
The number of difference will be less than 3^N.
The only case to reach 3^N is when rod = [1,3,9,27,81...]
 */
public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        // dp[d] means the maximum pair of sum we can get with pair difference = d
        int[] dp = new int[5001];
        for (int d = 1; d < 5001; d++) dp[d] = -10000;
        for (int x : rods) {
            int[] cur = dp.clone();
            for (int d = 0; d + x < 5001; d++) {
                // widen the difference
                dp[d + x] = Math.max(dp[d + x], cur[d]);

                // narrow the difference
                dp[Math.abs(d - x)] = Math.max(dp[Math.abs(d - x)], cur[d] + Math.min(d, x));
            }
        }
        return dp[0];
    }
    public int tallestBillboardOpt(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>(), cur;
        dp.put(0, 0);
        for (int x : rods) {
            cur = new HashMap<>(dp);
            for (int d : cur.keySet()) {
                dp.put(d + x, Math.max(cur.get(d), dp.getOrDefault(x + d, 0)));
                dp.put(Math.abs(d - x), Math.max(cur.get(d) + Math.min(d, x), dp.getOrDefault(Math.abs(d - x), 0)));
            }
        }
        return dp.get(0);
    }

    public static void main(String[] args) {
        TallestBillboard tb = new TallestBillboard();
        int[][] rods = new int[2][];
        rods[0] = new int[]{1, 2, 3, 6};
        int[] tallest = new int[2];
        tallest[0] = tb.tallestBillboard(rods[0]);

        rods[1] = new int[]{1, 2, 4, 9};
        tallest[1] = tb.tallestBillboard(rods[1]);

        int[]expected = {6, 0};

        Assert.assertArrayEquals(expected, tallest);
    }
}
