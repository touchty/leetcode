package array;

// Kadane’s Algorithm:
public class MaxSubArraySum {
    public static int maxSubArraySum(int a[]) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    public static int minSubArraySum(int a[]) {
        int size = a.length;
        int min_so_far = Integer.MAX_VALUE, min_ending_here = 0;

        for (int i = 0; i < size; i++) {
            min_ending_here = min_ending_here + a[i];
            if (min_so_far > min_ending_here)
                min_so_far = min_ending_here;
            if (min_ending_here > 0)
                min_ending_here = 0;
        }
        return min_so_far;
    }
}
