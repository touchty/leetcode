package array;

import java.util.Arrays;

/**
 * Given an array of integers A, consider all non-empty subsequences of A.
 * <p>
 * For any sequence S, let the width of S be the difference between the maximum and minimum element of S.
 * <p>
 * Return the sum of the widths of all subsequences of A.
 * <p>
 * As the answer may be very large, return the answer modulo 10^9 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [2,1,3]
 * Output: 6
 * Explanation:
 * Subsequences are [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3].
 * The corresponding widths are 0, 0, 0, 1, 1, 2, 2.
 * The sum of these widths is 6.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= 20000
 */

/*
Solution:
The order in initial arrays doesn't matter,
my first intuition is to sort the array.

For A[i]:
The idea is :
If A[i] is computed in a "width", it must be the maximum or minimum!
For the maximum, A[i] * (2 ^ i) should be added to the result.
For the minimum, A[i] * 2 ^ (n - i - 1) should be subtracted from the result.

There are i smaller numbers,
so there are 2 ^ i sequences in which A[i] is maximum.
we should do res += A[i] * (2 ^ i)

There are n - i - 1 bigger numbers,
so there are 2 ^ (n - i - 1) sequences in which A[i] is minimum.
we should do res -= A[i] * 2 ^ (n - i - 1)

Done.

Time Complexity:
O(NlogN)
*/
public class SumOfSubsequenceWidths {
    public int sumSubseqWidths(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        Arrays.sort(A);
        long c = 1;
        long result = 0;
        long mod = (long) 1e9 + 7;

        for (int i = 0; i < A.length; i++, c = (c << 1) % mod) {
            result = (result + A[i] * c - A[A.length - 1 - i] * c) % mod;
        }

        return (int) ((result + mod) % mod);
    }
}

