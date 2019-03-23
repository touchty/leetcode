package algorithms;

public class MyQuickSort {
    private int[] array;
    private int length;

    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length <= 1) {
            return;
        }
        array = inputArr;
        length = array.length;
        sort(0, length - 1);
    }

    private void sort(int lo, int hi) {
        if (lo >= hi) return;
        int i = lo;
        int j = hi;
        int mid = (lo + hi) / 2;
        int pivot = array[mid];
        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        sort(lo, j);
        sort(i, hi);
    }

    public static void main(String a[]) {

        MyQuickSort sorter = new MyQuickSort();
        int[] input = {24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12};
        sorter.sort(input);
        for (int i : input) {
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
