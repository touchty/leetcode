package dp;

import org.junit.Assert;

/*
974. Subarray Sums Divisible by K
Medium

119

6

Favorite

Share
Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.



Example 1:

Input: A = [4,5,0,-2,-3,1], K = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by K = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 */
public class SubarraySumsDivisibleByK {
    // brutal force
    public int subarraysDivByK(int[] A, int K) {
        int[] sum = new int[A.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        int count = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = i + 1; j < sum.length; j++) {
                if (((sum[j] - sum[i]) % K) == 0) {
                    count++;
                }
            }

        }
        return count;
    }

    public static int subarraysDivByKOpt(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0, sum = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            if (sum < 0) sum += K;  // Because -1 % 5 = -1, but we need the positive mod 4
            // if the same sum occurs twice, there must be a sub array with a sum of n * K
            // sum == 0 should be considered specially, because it do not need happen twice
            count += map[sum];
            map[sum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 0, -2, -3, 1};
        int K = 5;
        int res = SubarraySumsDivisibleByK.subarraysDivByKOpt(A, K);
        int expected = 7;
        Assert.assertEquals(expected, res);
    }
}
