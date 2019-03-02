package binarySearch;

/*
540. Single Element in a Sorted Array
Medium

645

55

Favorite

Share
Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
 */

/*
[1,1,2,3,3,4,4,8,8]
     ^
 */
public class SingleElementinaSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];

                // [11 22 33 44 5 66] the start of the pair is even
                // single element is in the left part
            else if (nums[mid] == nums[mid + 1] && mid % 2 == 0)
                low = mid + 1;
            else if (nums[mid] == nums[mid - 1] && mid % 2 == 1)
                low = mid + 1;
                // single element is in the right part
            else
                high = mid - 1;
        }
        return nums[low];
    }

    public int singleNonDuplicateOpt(int[] nums) {
        // binary search
        int n = nums.length, lo = 0, hi = n / 2;
        while (lo < hi) {
            int m = (lo + hi) / 2;
            if (nums[2 * m] != nums[2 * m + 1]) hi = m; // single element in the left
            else lo = m + 1; // single element in the right
        }
        return nums[2 * lo];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3};
        int res = SingleElementinaSortedArray.singleNonDuplicate(nums);
        System.out.println(res);

        nums = new int[]{1, 2, 2};
        res = SingleElementinaSortedArray.singleNonDuplicate(nums);
        System.out.println(res);
    }
}
