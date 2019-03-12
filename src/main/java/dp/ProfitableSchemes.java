package dp;

/*
879. Profitable Schemes
Hard

132

13

Favorite

Share
There are G people in a gang, and a list of various crimes they could commit.

The i-th crime generates a profit[i] and requires group[i] gang members to participate.

If a gang member participates in one crime, that member can't participate in another crime.

Let's call a profitable scheme any subset of these crimes that generates at least P profit, and the total number of gang members participating in that subset of crimes is at most G.

How many schemes can be chosen?  Since the answer may be very large, return it modulo 10^9 + 7.



Example 1:

Input: G = 5, P = 3, group = [2,2], profit = [2,3]
Output: 2
Explanation:
To make a profit of at least 3, the gang could either commit crimes 0 and 1, or just crime 1.
In total, there are 2 schemes.
Example 2:

Input: G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
Output: 7
Explanation:
To make a profit of at least 5, the gang could commit any crimes, as long as they commit one.
There are 7 possible schemes: (0), (1), (2), (0,1), (0,2), (1,2), and (0,1,2).
 */

/*
Algorithms:
Well, it is a Knapsack problem and my first intuition is dp.
dp[i][j] means the count of schemes with i profit and j members.
The dp equation is simple here:
dp[i + p][j + g] += dp[i][j]) if i + p < P
dp[P][j + g] += dp[i][j]) if i + p >= P
Don't forget to take care of overflow.
For each pair (p, g) of (profit, group), I update the count in dp.
Time Complexity:
O(NPG)
 */

/*
The reason why we update from the right bottom corner to the left top:
Think a situation that we have the dp[i][j] in k, and we have to update the dp[i][j] for k + 1;
Now all the data in dp[i][j] is old, if we go from top left to right bottom, we are going to use some data we have
updated. (In this case we may calculate the (k + 1)th group and profit multiple times.)
It is because we have the optimal structure like this:
dp[min(i + p, P)][j + g] = (dp[min(i + p, P)][j + g] + dp[i][j]) % mod;
So it is correct to update from right bottom to top left because we are not using our updated data.
 */
public class ProfitableSchemes {
    public static int profitableSchemes(int G, int P, int[] group, int[] profit) {
        // dp[i][j] means the count of schemes with (ge i) profit and (j) members.
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        int res = 0, mod = (int) 1e9 + 7;
        for (int k = 0; k < group.length; k++) {
            int g = group[k], p = profit[k];
            for (int i = P; i >= 0; i--)
                for (int j = G - g; j >= 0; j--)
                    dp[Math.min(i + p, P)][j + g] = (dp[Math.min(i + p, P)][j + g] + dp[i][j]) % mod;
        }
        for (int x : dp[P]) res = (res + x) % mod;
        return res;
    }

    public static void main(String[] args) {
        int[] group = {2, 2};
        int[] profit = {2, 3};
        int G = 5;
        int P = 3;
        System.out.println(ProfitableSchemes.profitableSchemes(G, P, group, profit));
    }
}
