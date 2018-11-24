package algorithms;

/**
 * bottom-up
 */

import org.junit.Assert;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void merge(double[] a,
                             int iLeft, int iMiddle, int iRight,
                             double[] tmp) {
        int i, j, k;

        i = iLeft;
        j = iMiddle;
        k = iLeft;

        /*while (i < iMiddle && i < a.length || j < iRight && j < a.length) {
            if (i < iMiddle && j < iRight) {  // Both array have elements
                if (a[i] < a[j])
                    tmp[k++] = a[i++];
                else
                    tmp[k++] = a[j++];
            } else if (i == iMiddle)
                tmp[k++] = a[j++];     // a is empty
            else if (j == iRight)
                tmp[k++] = a[i++];     // b is empty
        }*/

        while (i < iMiddle || j < iRight) {
            if (i < iMiddle && j < iRight) {  // Both array have elements
                if (a[i] < a[j])
                    tmp[k++] = a[i++];
                else
                    tmp[k++] = a[j++];
            } else if (i == iMiddle)
                tmp[k++] = a[j++];     // a is empty
            else if (j == iRight)
                tmp[k++] = a[i++];     // b is empty
        }

        // copy back to a
        for (int pos = iLeft; pos < iRight; pos ++) {
            a[pos] = tmp[pos];
        }
    }

    public static void sort(double[] a, double[] tmp) {
        int width;

        for (width = 1; width < a.length; width = 2 * width) {
            // Combine sections of array a of width "width"
            int i;

            for (i = 0; i < a.length; i = i + 2 * width) {
                int left, middle, right;

                left = i;
                middle = i + width;
                right = i + 2 * width;
                middle = Math.min(middle, a.length);
                right = Math.min(right, a.length);
                merge(a, left, middle, right, tmp);
            }
        }
    }
    static boolean isSorted(double[] array) {
        for (int i = 0; i < array.length - 1; i++){
            if (array[i] > array[i+1])
                return false;
        }
        return true;
    }
    public static void main( String[] args )
    {

        double[] x = {6.4, 3.5, 7.5, 2.5, 8.9, 4.2, 9.2, 1.1, 6.6, 6.7, 6.5,11} ;
        double[] help = new double[x.length];

        System.out.println("Before sort:  " + Arrays.toString(x) );

        MergeSort.sort( x, help );  // Merge sort

        assert isSorted(x);

        System.out.println("After sort:  " + Arrays.toString(x) );

        Random random = new Random();
        int LEN = 1025;
        double[] nums = new double[LEN];
        double[] helper = new double[LEN];
        for (int i = 0; i < LEN; i++) {
            nums[i] = random.nextDouble();
        }
        MergeSort.sort(nums, helper);
        Assert.assertTrue(isSorted(nums));
    }
}
