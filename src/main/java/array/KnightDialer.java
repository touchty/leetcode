package array;

import org.junit.Assert;

/**
 * A chess knight can move as indicated in the chess diagram below:
 * This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.
 * Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.
 * How many distinct numbers can you dial in this manner?
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * Input: 1
 * Output: 10
 * <p>
 * Example 2:
 * Input: 2
 * Output: 20
 * <p>
 * Example 3:
 * Input: 3
 * Output: 46
 */
public class KnightDialer {
    public static int knightDialer(int N) {
        // 8 directions(+-1, +-2), (+-2, +-1)
        int[][] directions = new int[8][2];
        directions[0] = new int[]{1, 2};
        directions[1] = new int[]{1, -2};
        directions[2] = new int[]{-1, 2};
        directions[3] = new int[]{-1, -2};
        directions[4] = new int[]{2, 1};
        directions[5] = new int[]{2, -1};
        directions[6] = new int[]{-2, 1};
        directions[7] = new int[]{-2, -1};

        long mod = 1000_000_000 + 7;
        long x1, x2, x3, x4, x5, x6, x7, x8, x9, x0;
        x1 = x2 = x3 = x4 = x5 = x6 = x7 = x8 = x9 = x0 = 1;

        for (int i = 0; i < N - 1; i++) {
            long xx1 = x6 + x8;
            long xx2 = x7 + x9;
            long xx3 = x4 + x8;
            long xx4 = x7 + x9 + x0;
            long xx5 = 0;
            long xx6 = x1 + x7 + x0;
            long xx7 = x2 + x6;
            long xx8 = x1 + x7;
            long xx9 = x2 + x4;
            long xx0 = x4 + x6;
            x1 = xx1 % mod;
            x2 = xx2 % mod;
            x3 = xx3 % mod;
            x4 = xx4 % mod;
            x5 = xx5 % mod;
            x6 = xx6 % mod;
            x7 = xx7 % mod;
            x8 = xx8 % mod;
            x9 = xx9 % mod;
            x0 = xx0 % mod;
        }
        long res = (x1 + x2 + x3 + x4 + x5 + x6 + x7 + x8 + x9 + x0) % mod;
        return (int) res;
    }

    public static void main(String[] args) {
        int N = 161;
        int expected = 533302150;
        int result = knightDialer(N);
        Assert.assertEquals(expected, result);
    }
}
