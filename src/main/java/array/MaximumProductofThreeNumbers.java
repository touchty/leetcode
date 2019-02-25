package array;

import java.util.Arrays;

/*
628. Maximum Product of Three Numbers
Easy

595

242

Favorite

Share
Given an integer array, find three numbers whose product is maximum and output the maximum product.

Example 1:

Input: [1,2,3]
Output: 6


Example 2:

Input: [1,2,3,4]
Output: 24
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] A) {
        int n = A.length;
        Arrays.sort(A);
        return Math.max(A[0] * A[1] * A[n - 1], A[n - 3] * A[n - 2] * A[n - 1]);
    }
}
