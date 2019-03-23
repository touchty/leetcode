package array;

import org.junit.Assert;

/**
 * 868. Binary Gap
 * Easy
 * 92
 * 230
 * Favorite
 * Share
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 * If there aren't two consecutive 1's, return 0.
 * Example 1:
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 * Example 3:
 * <p>
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 * Example 4:
 * <p>
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 */
public class BinaryGap {
    public static int binaryGap(int N) {
        int res = 0;
        int d = Integer.MIN_VALUE;
        while (N > 0) {
            if (N % 2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
            d++;
            N /= 2;
        }
        return res;
    }

    public static int binaryGapConsecutive(int N) {
        int prev = 0;
        int curr = 0;
        int MAXGAP = 0;
        while (N > 0) {
            if ((N % 2) == 0) {
                MAXGAP = Math.max(MAXGAP, curr - prev);
                prev = curr + 1;
            }
            curr++;
            N /= 2;
        }
        MAXGAP = Math.max(MAXGAP, curr - prev);
        return MAXGAP;
    }

    public static void main(String[] args) {
        int N = 22;
        int gap = BinaryGap.binaryGap(N);
        int expected = 2;
        Assert.assertEquals(expected, gap);

        N = 5;
        int len = BinaryGap.binaryGapConsecutive(N);
        Assert.assertEquals(len, 1);
    }
}
