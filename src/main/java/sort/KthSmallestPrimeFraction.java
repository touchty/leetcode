package sort;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
786. K-th Smallest Prime Fraction
Hard

186

9

Favorite

Share
A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.

What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.

Examples:
Input: A = [1, 2, 3, 5], K = 3
Output: [2, 5]
Explanation:
The fractions to be considered in sorted order are:
1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
The third fraction is 2/5.
Input: A = [1, 7], K = 1
Output: [1, 7]
 */
public class KthSmallestPrimeFraction {
    // 450 ms
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int n = A.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(A[a[0]] * A[n - 1 - b[1]], A[n - 1 - a[1]] * A[b[0]]);
            }
        });

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0});
        }

        while (--K > 0) {
            int[] p = pq.poll();

            if (++p[1] < n) {
                pq.offer(p);
            }
        }

        return new int[]{A[pq.peek()[0]], A[n - 1 - pq.peek()[1]]};
    }

    public static class Solution {
        public int[] kthSmallestPrimeFraction(int[] primes, int K) {
            double lo = 0, hi = 1;
            int[] ans = new int[]{0, 1};

            while (hi - lo > 1e-9) {
                double mi = lo + (hi - lo) / 2.0;
                int[] res = under(mi, primes);
                if (res[0] < K) {
                    lo = mi;
                } else {
                    ans[0] = res[1];
                    ans[1] = res[2];
                    hi = mi;
                }
            }
            return ans;
        }

        public int[] under(double x, int[] primes) {
            // Returns {count, numerator, denominator}
            int numer = 0, denom = 1, count = 0, i = -1;
            for (int j = 1; j < primes.length; ++j) {
                // For each j, find the largest i so that primes[i] / primes[j] < x
                // It has to be at least as big as the previous i, so reuse it ("two pointer")
                while (primes[i + 1] < primes[j] * x) ++i;

                // There are i+1 fractions: (primes[0], primes[j]),
                // (primes[1], primes[j]), ..., (primes[i], primes[j])
                count += i + 1;
                if (i >= 0 && numer * primes[j] < denom * primes[i]) {
                    numer = primes[i];
                    denom = primes[j];
                }
            }
            return new int[]{count, numer, denom};
        }
    }

    public static void main(String[] args) {
        int[] primes = {1, 2, 3, 5};
        int K = 3;
        KthSmallestPrimeFraction fraction = new KthSmallestPrimeFraction();
        Solution solution = new Solution();
        int[] res = solution.kthSmallestPrimeFraction(primes, K);
        System.out.println("(" + res[0] + ", " + res[1] + ")");
    }
}
