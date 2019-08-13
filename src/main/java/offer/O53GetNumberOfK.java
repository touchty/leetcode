package offer;

public class O53GetNumberOfK {
    public int GetNumberOfK(int[] nums, int K) {
        int first = binarySearch(nums, K);
        int second = binarySearch(nums, K+1);
        if (first == nums.length || nums[first] != K)
            return 0;
        else return second - first;
    }

    int binarySearch(int[] nums, int K) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int mid = (h + l) / 2;
            if (nums[mid] >= K) {
                h = mid;
            } else
                l = mid + 1;
        }
        return l;
    }
}
