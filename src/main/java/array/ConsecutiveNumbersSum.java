package array;

import org.junit.Assert;

/*
829. Consecutive Numbers Sum
Hard

162

208

Favorite

Share
Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:

Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
Note: 1 <= N <= 10 ^ 9.

Accepted
10.3K
Submissions
31.5K
 */
public class ConsecutiveNumbersSum {
    // start from x, x >= 1
    // m element, m >= 1
    // mx + {0 + 1 + 2 + ... + (m-1)}
    // = mx + m(m-1)/2
    public int consecutiveNumbersSum(int N) {
        int m = 1;
        int res = 0;
        for (; ; m++) {
            int sum = m * (m - 1) / 2;
            if (sum >= N) break;
            if ((N - sum) % m == 0) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 9;
        ConsecutiveNumbersSum s = new ConsecutiveNumbersSum();
        int combinations = s.consecutiveNumbersSum(N);
        int expected = 3;
        Assert.assertEquals(expected, combinations);
    }
}
