package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
378. Kth Smallest Element in a Sorted Matrix
Medium

1021

76

Favorite

Share
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
 */
public class KthSmallestSortedMatrix {

    // if the element is still in the pq (minpq), its right is not a candidate.
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> matrix[a[0]][a[1]]));

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0});  // initialize the pool with elements from the first column
        }

        while (--k > 0) {                // remove the smallest elements from the matrix (k-1) times
            int[] p = pq.poll();

            if (++p[1] < n) {
                pq.offer(p);             // add the next element in the same row if it exists
            }
        }

        return matrix[pq.peek()[0]][pq.peek()[1]];
    }
}
