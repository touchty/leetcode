package dp;

import java.util.Arrays;

public class MinimumSwapsTo {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n];
        int[] no_swap = new int[n];
        Arrays.fill(swap, n);
        Arrays.fill(no_swap, n);
        swap[0] = 1;
        no_swap[0] = 0;

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                // If we swap position i, we need to swap position i - 1.
                swap[i] = swap[i - 1] + 1;

                // If we don't swap position i , we should not swap position i - 1.
                no_swap[i] = no_swap[i - 1];

            }

            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                // If we swap position i, we should not swap position i - 1.
                swap[i] = Math.min(swap[i], no_swap[i - 1] + 1);

                // If we don't swap position i, we should swap position i - 1.
                no_swap[i] = Math.min(no_swap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[n - 1], no_swap[n - 1]);
    }
}
