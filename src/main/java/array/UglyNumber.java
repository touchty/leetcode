package array;

import org.junit.Assert;

/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 *
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 *
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */
public class UglyNumber {
    public static boolean isUgly(int num) {
        int[] factors = {2, 3, 5};
        if (num == 0) return false;
        if (num == 1) return true;
        while (num != 0) {
            boolean isFactor = false;
            for (int factor : factors) {
                if (num == 0)
                    break;
                if (num == factor)
                    return true;
                if (num % factor == 0) {
                    num /= factor;
                    isFactor = true;
                }
            }
            if (!isFactor) return false;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        int[] nums = {6, 14};
        boolean[] results = new boolean[nums.length];
        boolean[] expected = {true, false};

        for (int i = 0; i < nums.length; i++) {
            results[i] = isUgly(nums[i]);
        }
        Assert.assertArrayEquals(results, expected);
    }
}
