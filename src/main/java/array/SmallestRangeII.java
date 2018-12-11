package array;

import java.util.Arrays;

import org.junit.Assert;

/*
Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the minimum value of B.

 

Example 1:

Input: A = [1], K = 0
Output: 0
Explanation: B = [1]

Example 2:

Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]

Example 3:

Input: A = [1,3,6], K = 3
Output: 3
Explanation: B = [4,6,3]

*/
public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, mx = A[n - 1], mn = A[0], res = mx - mn;
        // add 2 * K to A[i]
        for (int i = 0; i < n - 1; ++i) {
            // max candidates
            mx = Math.max(mx, A[i] + 2 * K);
            //min candidates
            mn = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(res, mx - mn);
        }
        return res;
    }

    public static void main(String[] args) {
        int[]  A = {1,3,6};
        int K = 3;

        int expected = 3;
        int actual = new SmallestRangeII().smallestRangeII(A, K);

        Assert.assertEquals(expected, actual);
    }
}