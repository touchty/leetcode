package HRQuestion.xiaomi;

import java.util.Arrays;

public class Q_qimiao1 {
    // Very Short and Clear MergeSort & BST Java Solutions
    public int reversePairs_MergeSort(int[] nums) {
        int a = mergeSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * (-1);
        }
        int b = mergeSort(nums, 0, nums.length - 1);

        return Math.min(a, b);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int mid = s + (e - s) / 2;
        // after mergeSort1(nums, s, mid), nums[s...mid] is sorted.
        // after mergeSort1(nums, mid+1,e), nums[mid+1...e] is sorted.
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);

        // compare between two sorted subarrays, position of i and j respectively
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, s, e + 1);
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        Q_qimiao1 s = new Q_qimiao1();
        System.out.println(s.reversePairs_MergeSort(a));
    }
}
