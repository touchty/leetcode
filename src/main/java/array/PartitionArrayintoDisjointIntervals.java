package array;

/*
915. Partition Array into Disjoint Intervals
Medium

169

13

Favorite

Share
Given an array A, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.



Example 1:

Input: [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]
Example 2:

Input: [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]
 */
public class PartitionArrayintoDisjointIntervals {
    public int partitionDisjoint(int[] A) {
        int[] B = new int[A.length]; // minimum element in right part of A
        B[A.length - 1] = A[A.length - 1];
        int pmax = Integer.MIN_VALUE; // maximum element in left part of A
        for (int i = A.length - 2; i >= 0; i--) {
            B[i] = Math.min(B[i + 1], A[i]);
        }

        for (int i = 0; i < A.length - 1; i++) {
            pmax = Math.max(pmax, A[i]);
            if (pmax <= B[i + 1])
                return i + 1;
        }
        return -1;
    }
}
