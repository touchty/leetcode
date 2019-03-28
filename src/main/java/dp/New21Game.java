package dp;

/*
837. New 21 Game
Medium

243

139

Favorite

Share
Alice plays the following game, loosely based on the card game "21".

Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.

Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?

Example 1:

Input: N = 10, K = 1, W = 10
Output: 1.00000
Explanation:  Alice gets a single card, then stops.
Example 2:

Input: N = 6, K = 1, W = 10
Output: 0.60000
Explanation:  Alice gets a single card, then stops.
In 6 out of W = 10 possibilities, she is at or below N = 6 points.
Example 3:

Input: N = 21, K = 17, W = 10
Output: 0.73278
 */
public class New21Game {

    /*
    lee215 solution:
    Intuition:
    The same problems as "Climbing Stairs".

    Explanation:
    In a word,
    dp[i]: probability of get points i
    dp[i] = sum(last W dp values) / W

    To get Wsum = sum(last W dp values), we can maintain a sliding window with size at most K.

    Time Complexity:
    O(N)
     */
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) return 1;
        double dp[] = new double[N + 1], Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= N; ++i) {
            dp[i] = Wsum / W;
            if (i < K) Wsum += dp[i];
            else res += dp[i];
            if (i - W >= 0) Wsum -= dp[i - W];
            // maintain a sliding window. cannot jump from i-(W+1) to i, because the max leap
            // is W
        }
        return res;
    }
}
