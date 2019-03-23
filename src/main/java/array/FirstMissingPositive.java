package array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; ++i)
            while (A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i]) {
                // fatal error : array out of boundary
                /*int temp = A[i];
                A[i] = A[A[i] - 1];
                A[A[i] - 1] = temp;*/

                int j = A[i] - 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

        for (int i = 0; i < n; ++i)
            if (A[i] != i + 1)
                return i + 1;

        return n + 1;
    }
}
