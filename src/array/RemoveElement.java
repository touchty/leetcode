package array;

import java.util.Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        Arrays.sort(nums);
        int start = Arrays.binarySearch(nums, val);
        if (start < 0) return len;

        // start >= 0
        int left = start, right = start;
        while (left >= 0){
            if (nums[left] == val) left--;
            else break;
        }
        while (right < len) {
            if (nums[right] == val) right++;
            else break;
        }

        int n = right - left - 1;
        while (right < len) {
            nums[++left] = nums[right++];
        }
        return len - n;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int n = 2;
        System.out.println(RemoveElement.removeElement(nums, n));
    }
}
