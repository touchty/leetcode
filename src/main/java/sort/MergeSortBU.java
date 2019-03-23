package sort;

public class MergeSortBU {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];  // this copying is unneccessary
            else if (j > hi) a[k] = aux[i++];
            else if ((aux[j].compareTo(aux[i])) < 0) {
                a[k] = aux[j++];
            } else a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                merge(a, aux, lo, mid, hi);
            }
        }
    }

    static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"My", "Idea", "Hello", "Zoo", "Below", "Cat", "All"};
        MergeSortBU.sort(a);
        for (String str : a)
            System.out.println(str);

        if (!isSorted(a))
            System.out.println("Error!");
    }
}
