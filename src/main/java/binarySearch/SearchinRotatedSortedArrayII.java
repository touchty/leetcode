package binarySearch;

public class SearchinRotatedSortedArrayII {
    boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) return true;

            // the only difference from the first one, trickly case, just updat left and right
            if ((nums[left] == nums[mid]) && (nums[right] == nums[mid])) {
                ++left;
                --right;
            }

            // left part is in order
            else if (nums[left] <= nums[mid]) {
                if ((nums[left] <= target) && (nums[mid] > target)) right = mid - 1;
                else left = mid + 1;
            }
            // right part is in order
            else {
                if ((nums[mid] < target) && (nums[right] >= target)) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    boolean searchReWrite(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (nums[mid] == target) return true;

            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right++;
            }

            // left part is in order
            if (nums[mid] >= nums[left]) {
                if (nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
            // right part is in order
            else {
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}