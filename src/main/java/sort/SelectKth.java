package sort;

import org.junit.Assert;

public class SelectKth {
    int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (nums[++i] < v) {
                if (i == hi) break;
            }
            while (nums[--j] > v) {
                if (j == lo) break;
            }
            if (j <= i) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    private  int partitionOpt(int[] a, int lo, int hi) {
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

            swap(a, i, j);
        }

        // put partitioning item v at a[j]
        swap(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    int selectKth(int[] nums, int kth) {
        if (kth >= nums.length || kth < 0) return -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int p = partitionOpt(nums, lo, hi);
            if (p == kth) return nums[p];
            else if (p < kth) lo = p + 1;
            else hi = p - 1;
        }
        return nums[lo];
    }

    void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 2, 4, 6};
        int[] kths = {0, 1, 2, 3, 4, 5, 6};
        int[] kthNums = new int[kths.length];
        SelectKth solution = new SelectKth();
        for (int i = 0; i < nums.length; i++) {
            int kthNum = solution.selectKth(nums, i);
            kthNums[i] = kthNum;
            System.out.println(kthNum);
        }
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        Assert.assertArrayEquals(expected, kthNums);
    }
}
