package binarySearch;

public class FindMinimuminRotatedSortedArray {
    /*
     * int[] nums = {7,8,9,10,1,2,3,4,5,6}; find disorder in right part;
     * */
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }
}
