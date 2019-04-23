package binarySearch;

/*
4. Median of Two Sorted Arrays
Hard

4076

548

Favorite

Share
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class MedianofTwoSortedArrays {
    double findMedianSortedArrays(int A[], int m, int B[], int n) {
        int l = (m + n + 1) >> 1;
        int r = (m + n + 2) >> 1;
        return (getkth(A, 0, m, B, 0, n, l) + getkth(A, 0, m, B, 0, n, r)) / 2.0;
    }

    /**
     * @param A      数组一
     * @param startA A的起点
     * @param m      A接下来的长度
     * @param B      数组二
     * @param startB B的起点
     * @param n      B接下来的长度
     * @param k      第k小的数
     * @return 第k小的数
     */
    int getkth(int A[], int startA, int m, int[] B, int startB, int n, int k) {
        // startBet m <= n
        if (k > m + m || k <= 0) return Integer.MIN_VALUE;
        if (m > n)
            return getkth(B, startB, n, A, startA, m, k);
        if (m == 0)
            return B[startB + k - 1];
        if (k == 1)
            return Math.min(A[startA], B[startB]);

        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (A[startA + i - 1] > B[startB + j - 1])
            return getkth(A, startA, m, B, startB + j, n - j, k - j);
        else
            return getkth(A, startA + i, m - i, B, startB, n, k - i);
    }


    public static void main(String[] args) {
        int[] A = {1, 3, 6, 9};
        int[] B = {2, 4, 5, 7, 14, 16};
        MedianofTwoSortedArrays solution = new MedianofTwoSortedArrays();
        double median = solution.findMedianSortedArrays(A, A.length, B, B.length);
        //System.out.println(median);
        int posof2 = solution.getkth(A, 0, A.length, B, 0, B.length, 100);
        System.out.println(posof2);
    }
}
