package HRQuestion.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

public class Q_qimiao1 {
    // Very Short and Clear MergeSort & BST Java Solutions
    public int reversePairs_MergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int mid = s + (e - s) / 2;
        // after mergeSort1(nums, s, mid), nums[s...mid] is sorted.
        // after mergeSort1(nums, mid+1,e), nums[mid+1...e] is sorted.
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e);

        // compare between two sorted subarrays, position of i and j respectively
        for (int i = s, j = mid + 1; i <= mid; i++) {
            while (j <= e && nums[i] / 2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, s, e + 1);
        return cnt;
    }
}
