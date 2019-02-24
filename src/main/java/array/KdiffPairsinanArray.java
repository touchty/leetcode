package array;

import java.util.Arrays;

/*
532. K-diff Pairs in an Array
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a
k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute
difference is k.
Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
 */
public class KdiffPairsinanArray {
    public static int findPairs(int[] a, int k) {
        if (a.length <= 1) return 0;
        Arrays.sort(a);
        int start = 0;
        int end = 0;
        int pairCount = 0;

        while (start < a.length && end < a.length) {
            if (start == end || a[start] + k > a[end]) end++;
            else if (a[start] + k < a[end]) start++;
            else {
                pairCount++;
                start++;

                while (end < a.length - 1 && a[end] == a[end + 1]) end++;
                // skip duplicates. still need one more increase
                end++;
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,3,3,4,5};
        int k = 2;
        int res = KdiffPairsinanArray.findPairs(a, k);
        System.out.println(res);
    }
}
