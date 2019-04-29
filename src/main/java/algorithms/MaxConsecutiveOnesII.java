package algorithms;

public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int j = 0;
        int max = 0;
        int k = 1;
        int countOne = 0;
        while (j < nums.length) {
            if (nums[j] == 1) countOne++;
            if (j - i + 1 - countOne <= k) {
                max = Math.max(max, j - i + 1);
            } else {
                if (nums[i] == 1) countOne--;
                i++;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1, 0, 1, 0, 1};
        int[] B = {1, 0, 1, 1, 0};
        MaxConsecutiveOnesII solution = new MaxConsecutiveOnesII();
        int res = solution.findMaxConsecutiveOnes(A);
        int res1 = solution.findMaxConsecutiveOnes(B);
        System.out.println(res); // 3
        System.out.println(res1); // 4
    }
}
