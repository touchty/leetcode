package sort;

import java.util.Random;

public class QuickDemo {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (a[++i] < v) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (v < a[--j]) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean isSorted(int[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (a[i] < a[i - 1]) return false;
        return true;
    }

    public static void main(String[] args) {
        int N = 10000;
        int[] arr = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt();
        }
        QuickDemo.sort(arr);
        boolean isSorted = QuickDemo.isSorted(arr);
        System.out.println(isSorted);
    }
}
