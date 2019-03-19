package pq;

import java.util.Arrays;

public class MinHeap {
    int[] arr;
    int N;

    public MinHeap(int cap) {
        this.arr = new int[cap];
        N = 0;
    }

    public MinHeap() {
        this.arr = new int[1];
        N = 0;
    }

    public MinHeap(int[] keys) {
        N = keys.length;
        arr = new int[keys.length + 1];
        for (int i = 0; i < N; i++)
            arr[i + 1] = keys[i];
        for (int k = N / 2; k >= 1; k--)
            sink(arr, k, N);
    }

    void sink(int[] array, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            while (j < n && array[j] > array[j + 1]) j++;
            if (array[j] <= array[k]) break;
            swap(array, k, j);
            k = j;
        }
    }

    void swim(int[] array, int k, int n) {
        while (k > 1 && array[k] < array[k / 2]) {
            swap(array, k, k / 2);
            k /= 2;
        }
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] sort() {
        int n = N;
        while (n >= 1) {
            swap(arr, 1, n);
            n--;
            sink(arr, 1, n);
        }
        int[] res = Arrays.copyOf(arr, N);
        N = 0;
        arr = new int[0];
        return res;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 2, 4, 6, 8};
        MinHeap minHeap = new MinHeap(array);
        int[] sorted = minHeap.sort();
        for (int i : sorted)
            System.out.println(i);
    }
}
