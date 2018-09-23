package array;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGameII {
    public static int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int low = 0, high = 0;
        for (int k = 0; k < nums.length; k++) {
            if (low > high) break;
            int farthest = 0;
            for (int i = low; i < high + 1; i++) {
                if (nums[i] + i >= nums.length - 1) return k + 1;
                farthest = Math.max(farthest, nums[i] + i);
            }
            low = high + 1;
            high = farthest;
        }
        throw new java.lang.RuntimeException("No such path!");
    }

    static int jumpOpt(int A[]) {
        int n = A.length;

        if (n < 2) return 0;
        int level = 0, currentMax = 0, i = 0, nextMax = 0;

        while (currentMax - i + 1 > 0) {        //nodes count of current level>0
            level++;
            for (; i <= currentMax; i++) {    //traverse current level , and update the max reach of next level
                nextMax = Math.max(nextMax, A[i] + i);
                if (nextMax >= n - 1) return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax = nextMax;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
        System.out.println(jumpOpt(nums));
    }
}
