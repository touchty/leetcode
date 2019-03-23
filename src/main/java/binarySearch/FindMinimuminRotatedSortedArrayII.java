package binarySearch;

public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            }
            // When num[mid] == num[hi], we couldn't sure the position of minimum in mid's left or right, so just let
            // upper bound reduce one.
            else {
                hi--;
            }
        }
        return nums[lo];
    }
}
