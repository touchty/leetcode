package binarySearch;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] a) {
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < a.length){
            sum += a[j++];
            while(sum >= s){
                min = Math.min(min, j-i);
                sum -= a[i++];
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
