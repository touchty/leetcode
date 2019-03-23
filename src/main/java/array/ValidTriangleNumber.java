package array;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static int triangleNumber(int[] A) {
        Arrays.sort(A);
        int count = 0;

        for (int i = A.length - 1; i > 1; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;
                    r--;
                } else l++;
            }
        }

        return count;
    }
}
