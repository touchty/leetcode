package array;

/*
1020. Partition Array Into Three Parts With Equal Sum
Easy

41

8

Favorite

Share
Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])



Example 1:

Input: [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public static boolean canThreePartsEqualSum(int[] A) {
        int[] sums = new int[A.length + 1];
        int K = 3; // Three Parts
        for (int i = 0; i < A.length; i++) {
            sums[i + 1] = sums[i] + A[i];
        }
        int target = sums[A.length] / K;
        if (sums[A.length] % K != 0)
            return false;

        int p = 0;
        int[] partion = new int[3];
        while (++p <= A.length) {
            if (sums[p] % target != 0)
                continue;
            if (sums[p] == target) {
                partion[0] = 1;
            } else if (sums[p] == target * 2 && partion[0] == 1) {
                partion[1] = 1;
            } else if (sums[p] == target * 3 && partion[1] == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        boolean result = PartitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(A);
        System.out.println(result);
    }
}
