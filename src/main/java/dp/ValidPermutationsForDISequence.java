package dp;

import org.junit.Assert;

/**
 * 903. Valid Permutations for DI Sequence
 * Hard
 *
 * 123
 *
 * 16
 *
 * Favorite
 *
 * Share
 * We are given S, a length n string of characters from the set {'D', 'I'}. (These letters stand for "decreasing" and "increasing".)
 *
 * A valid permutation is a permutation P[0], P[1], ..., P[n] of integers {0, 1, ..., n}, such that for all i:
 *
 * If S[i] == 'D', then P[i] > P[i+1], and;
 * If S[i] == 'I', then P[i] < P[i+1].
 * How many valid permutations are there?  Since the answer may be large, return your answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: "DID"
 * Output: 5
 * Explanation:
 * The 5 valid permutations of (0, 1, 2, 3) are:
 * (1, 0, 3, 2)
 * (2, 0, 3, 1)
 * (2, 1, 3, 0)
 * (3, 0, 2, 1)
 * (3, 1, 2, 0)
 */

/*
Explanation:
As shown in the diagram,
for "I", we calculate prefix sum of the array,
for "D", we calculate sufixsum of the array.
 */
public class ValidPermutationsForDISequence {
    public static int numPermsDISequence(String S) {
        int n = S.length(), mod = (int)1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = 1;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == 'I')
                for (int j = 0, cur = 0; j < n - i; j++) {
                    cur = (cur + dp[i][j]) % mod;
                    dp[i + 1][j] = cur;
                }

            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--) {
                    cur = (cur + dp[i][j + 1]) % mod;
                    dp[i + 1][j] = cur;
                }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        String s = "DID";
        int res = ValidPermutationsForDISequence.numPermsDISequence(s);
        int expected = 5;
        Assert.assertEquals(expected, res);
    }
}
