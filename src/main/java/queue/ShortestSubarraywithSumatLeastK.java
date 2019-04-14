package queue;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

/*
862. Shortest Subarray with Sum at Least K
Hard

443

12

Favorite

Share
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.



Example 1:

Input: A = [1], K = 1
Output: 1
Example 2:

Input: A = [1,2], K = 4
Output: -1
Example 3:

Input: A = [2,-1,2], K = 3
Output: 3


Note:

1 <= A.length <= 50000
-10 ^ 5 <= A[i] <= 10 ^ 5
1 <= K <= 10 ^ 9
 */
public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        // B[i] = sum{0, A[0], ... A[i - 1]}
        // B[0] == 0;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
        Deque<Integer> d = new LinkedList<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >= K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()]) d.pollLast(); // keep B increasing in the queue
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }

    public static void main(String[] args) {
        int[] A = {2, -1, 2};
        int K = 1;
        ShortestSubarraywithSumatLeastK s = new ShortestSubarraywithSumatLeastK();
        int length = s.shortestSubarray(A, K);
        int expected = 3;
        //Assert.assertEquals(expected, length);
        System.out.println(length);
    }
}
