package array;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copy);
        int low = 0;
        int high = nums.length - 1;

        while (low < nums.length) {
            if (nums[low] == copy[low]) low++;
            else break;
        }
        while (high >= 0){
            if (nums[high] == copy[high]) high--;
            else break;
        }

        if (high > low)
            return high - low + 1;
        return 0;
    }

    public int findUnsortedSubarrayOpt(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }
    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();

        System.out.println(s.findUnsortedSubarray(nums));
    }
}
