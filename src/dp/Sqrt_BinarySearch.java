package dp;

public class Sqrt_BinarySearch {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) {
            return x;
        }
        int start = 1, end = x / 2;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == x / mid) {
                return mid;
            }
            if(mid < x / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start - 1;
    }
    public int mySqrtArray(int x) {
        if(x == 0 || x == 1) {
            return x;
        }

        int start = 0;
        int end = x/2;
        int[] nums = new int[end+1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        while(start <= end){
            int mid = start + (end-start)/2;
            if (nums[mid]* nums[mid] == x){
                return mid;
            }
            if (nums[mid]* nums[mid] > x){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start - 1;
    }
}
