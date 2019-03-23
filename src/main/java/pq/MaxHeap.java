package pq;

import java.util.Arrays;

public class MaxHeap {
    int[] pq;
    int N = 0;

    private MaxHeap() {

    }

    public int[] sort(int[] array) {
        pq = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            pq[i + 1] = array[i];
        }
        N = array.length;
        for (int i = N / 2; i >= 1; i--) {
            sink(pq, i, N);
        }
        int n = N;
        while (n >= 1) {
            swap(pq, 1, n);
            n--;
            sink(pq, 1, n);
        }
        return Arrays.copyOfRange(pq, 1, N + 1);
    }

    void sink(int[] array, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            while (j < n && array[j] <= array[j + 1]) j++;
            if (array[j] <= array[k]) break;
            swap(array, k, j);
            k = j;
        }
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 2, 4, 6, 8};
        int[] arraySorted = new MaxHeap().sort(array);
        for (int i : arraySorted) {
            System.out.println(i);
        }
    }
}
