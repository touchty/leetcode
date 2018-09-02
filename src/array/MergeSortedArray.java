package array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int pos = 0;

        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]){
                merged[pos++] = nums1[i++];
            }
            else{
                merged[pos++] = nums2[j++];
            }
        }

        while (i < m){
            merged[pos++] = nums1[i++];
        }

        while (j < n) {
            merged[pos++] = nums2[j++];
        }


        for (int k = 0; k < m + n && k < nums1.length; k++) {
            nums1[k] = merged[k];
        }

        return;
    }

    public void mergeOpt(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        assert pos <= nums1.length - 1;
        m--;
        n--;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]){
                nums1[pos--] = nums1[m--];
            }
            else {
                nums1[pos--] = nums2[n--];
            }
        }

        /*while (m >= 0) {
            nums1[pos--] = nums1[m--];
        }*/

        while (n >= 0) {
            nums1[pos--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        MergeSortedArray mergeSortedArray = new MergeSortedArray();

        mergeSortedArray.merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.println(num);
        }
    }
}
