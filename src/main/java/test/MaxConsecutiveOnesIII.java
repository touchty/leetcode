package test;

/*
最大连续的1
变形：最大连续的0或者1
1004. Max Consecutive Ones III
Medium

171

6

Favorite

Share
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.



Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */
public class MaxConsecutiveOnesIII {
    public int longestOnesZeroorOne(int[] A, int K) {
        if (A == null || A.length <= 0)
            return 0;

        int i = 0;
        int j = 0;
        int c0 = 0;
        int c1 = 0;
        int max = 0;
        while (j < A.length) {
            if (A[j] == 1) c1++;
            if (A[j] == 0) c0++;
            // consecutive 0 s or 1 s
            if (j - i + 1 - c1 <= K || j - i + 1 - c0 <= K) {
                max = Math.max(max, j - i + 1);
            } else {
                if (A[i] == 0) c0--;
                else c1--;
                i++;
            }
            j++;
        }
        return max;
    }

    public int longestOnes(int[] A, int K) {
        if (A == null || A.length <= 0)
            return 0;

        int i = 0;
        int j = 0;
        int c0 = 0;
        int c1 = 0;
        int max = 0;
        while (j < A.length) {
            if (A[j] == 1) c1++;
            if (A[j] == 0) c0++;
            if (j - i + 1 - c1 <= K) {
                max = Math.max(max, j - i + 1);
            } else {
                if (A[i] == 1) c1--;
                i++;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] A1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] A3 = {0, 0, 0, 0};
        int K3 = 0;
        MaxConsecutiveOnesIII s = new MaxConsecutiveOnesIII();
        int res = s.longestOnes(A, 2);
        int res1 = s.longestOnes(A1, 3);
        int res3 = s.longestOnes(A3, K3);
        System.out.println(res);
        System.out.println(res1);
        System.out.println(res3);
        int[] A4 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] A5 = {0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1};
        int res4 = s.longestOnesZeroorOne(A4, 2);
        int res5 = s.longestOnes(A4, 2);
        int res6 = s.longestOnes(A5, 2);
        System.out.println(res4);
        System.out.println(Math.max(res5, res6));
    }
}
