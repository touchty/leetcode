package array;

public class MaximumSumCircularSubarray {
    /*public int maxSubarraySumCircular(int[] A) {
        int[] sums = new int[A.length * 2];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i - 1] + A[(i - 1) % A.length];
        }

        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j <= i + A.length; j++) {
                max = Math.max(max, sums[j] - sums[i]);
            }
        }
        return max;
    }*/

    /*
    "==" means the element we select
    two conditions:
    1) subarray
    2) circular subarray
    1) |   |=====|     |
    2) |==|        |===|
     */
    public int maxSubarraySumCircular(int[] A) {
        int sum = 0;
        int max;
        for (int a : A) {
            sum += a;
        }
        int minContinuousSum = minSubArraySum(A);
        int maxContinuousSum = maxSubArraySum(A);
        if (minContinuousSum == sum) return maxContinuousSum; // at least select one element
        max = Math.max(maxContinuousSum, sum - minContinuousSum);
        return max;
    }

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

    public static void main(String[] args) {
        int[] A = {-2, -3, -1};
        MaximumSumCircularSubarray solution = new MaximumSumCircularSubarray();
        int max = solution.maxSubarraySumCircular(A);
        System.out.println(max);

        /*int[] A = {3, -3, 2, -3};
        System.out.println(solution.minSubArraySum(A));*/
    }
}
