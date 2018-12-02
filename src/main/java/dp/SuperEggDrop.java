package dp;

import org.junit.Assert;

/**
 * You are given K eggs, and you have access to a building with N floors from 1 to N.
 * Each egg is identical in function, and if an egg breaks, you cannot drop it again.
 * You know that there exists a floor F with 0 <= F <= N such that any egg dropped at a floor higher than F will break, and any egg dropped at or below floor F will not break.
 * Each move, you may take an egg (if you have an unbroken one) and drop it from any floor X (with 1 <= X <= N).
 * Your goal is to know with certainty what the value of F is.
 * What is the minimum number of moves that you need to know with certainty what F is, regardless of the initial value of F?

 * Example 1:
 * Input: K = 1, N = 2
 * Output: 2
 * Explanation:
 * Drop the egg from floor 1.  If it breaks, we know with certainty that F = 0.
 * Otherwise, drop the egg from floor 2.  If it breaks, we know with certainty that F = 1.
 * If it didn't break, then we know with certainty F = 2.
 * Hence, we needed 2 moves in the worst case to know what F is with certainty.
 * Example 2:
 *
 * Input: K = 2, N = 6
 * Output: 3
 * Example 3:
 *
 * Input: K = 3, N = 14
 * Output: 4
 */
public class SuperEggDrop {
    public static int superEggDrop(int K, int N) {
        // dp[i][j] min steps to find the certain K floor with i eggs within j floors
        int[][] dp = new int[K+1][N+1];
        for (int i = 0; i <= N; i++ ) {
            dp[0][i] = 0; //no egg, no floor can check
        }

        for (int j = 1; j <= N; j++) {
            dp[1][j] = j; // one egg, check floor from i to 1
        }

        for (int i = 1; i <= K; i++ ) {
            dp[i][1] = 1; // one floor, one check
        }

        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++) {
                    int res = 1 + Math.max(dp[i - 1][j-p], dp[i][p - 1]);
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }

        return dp[K][N];
    }

    /**
     * Drop eggs is a very classical problem.
     * Some people may come up with idea O(KN^2)
     * where dp[K][N] = 1 + max(dp[K - 1][i - 1],dp[K][N - i]) for i in 1...N.
     * However this idea is very brute force, for the reason that you check all possiblity.
     *
     * So I consider this problem in a different way:
     * dp[M][K]means that, given K eggs and M moves,
     * what is the maximum number of floor that we can check.
     *
     * The dp equation is:
     * dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1,
     * which means we take 1 move to a floor,
     * if egg breaks, then we can check dp[m - 1][k - 1] floors.
     * if egg doesn't breaks, then we can check dp[m - 1][k - 1] floors.
     *
     * dp[m][k] is similar to the number of combinations and it increase exponentially to N
     *
     * Time Complexity:
     * O(KlogN) Time, O(NK) Space
     */

    // SECOND SOLUTION
    //Here is an explanation:
    //We assume the minimum drop times is x, then the first egg should be dropped at the x floor:
    //reason 1 : If the egg breaks, we can still try from the floor 1 to floor x-1
    //reason 2 : If the egg doesn't break, we still have x-1 opportunities to find the F.
    //
    //If the egg doesn't break, the egg which is still the first one can start its second try from x + (x-1)floor. Because, if the current egg breaks when it is dropped from the x + (x-1) floor, the second egg still has x-2 opportunities and it can still try from x+1 floor to x + (x-2) floor. If the second egg doesn't break again, the third try can start from x + (x-1) + (x-2) floor.
    //
    //I hope it will help you.
    public int superEggDropOpt(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }

    public static void main(String[] args) {
        int K = 1, N = 2;
        int steps = superEggDrop(K, N);
        int expected = 2;
        Assert.assertEquals(steps, expected);

        K = 2;
        N = 6;
        steps = superEggDrop(K, N);
        expected = 3;
        Assert.assertEquals(steps, expected);
    }
}
