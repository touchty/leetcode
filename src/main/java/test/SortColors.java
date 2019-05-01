package test;

public class SortColors {
    void sortColors(int A[]) {
        int n = A.length;
        int j = 0, k = n - 1;
        for (int i = 0; i <= k; i++) {
            if (A[i] == 0)
                swap(A, i, j++);
            else if (A[i] == 2)
                swap(A, i--, k--);
        }
    }

    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
