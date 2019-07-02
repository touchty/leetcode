package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class JumpGame {
    public static boolean canJump(int[] nums) {
        int i = 0;
        int currentMax = 0;
        int nextMax = 0;
        while (i <= currentMax) {
            for (; i <= currentMax; i++) {
                int range = nums[i] + i;

                if (range >= nums.length - 1) return true;

                nextMax = Math.max(nextMax, range);
            }
            currentMax = nextMax;
        }

        return false;
    }

    // 跳到最后一个索引的最小跳数
    public static int jumpSteps(int[] A) {
//        int[] dp = new int[A.length]; // dp存放都到各点的最小步数
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i < dp.length; i++) {
//            int maxPosition = Math.min(i + A[i], A.length - 1); // 从i点出发能走的最远距离
//            for (int j = i + 1; j <= maxPosition; j++) {
//                //dp[j] = Math.min(dp[j], dp[i] + 1);
//                if(dp[j] == 0) dp[j] = dp[i] + 1;
//            }
//        }
//        return dp[A.length - 1];

        int[] dp = new int[A.length]; // dp存放都到各点的最小步数
        for (int i = 0; i < dp.length; i++) {
            int maxPosition = Math.min(i + A[i], A.length - 1); // 从i点出发能走的最远距离
            for (int j = i + 1; j <= maxPosition; j++) {
                if (dp[j] == 0) dp[j] = dp[i] + 1; // 如果位置没被走过,则到达j点的步数为dp[i]+1
            }
            if (dp[A.length - 1] != 0) break; // 当第一次到达终点时,肯定是到达终点最短的步数
        }
        return dp[A.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean canJump = JumpGame.canJump(nums);
        System.out.println(canJump);

        int minSteps = JumpGame.jumpSteps(nums);
        System.out.println(minSteps);
        int[] nums1 = {4, 1, 3, 1, 1, 1, 1};
        int minSteps1 = JumpGame.jumpSteps(nums1);
        System.out.println(minSteps1);
    }

    @Test
    public void testTrue() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean canJump = JumpGame.canJump(nums);
        boolean expected = true;
        Assert.assertEquals(expected, canJump);
    }

    @Test
    public void testFalse() {
        int[] nums = {2, 3, 1, 1, 0, 0, 4};
        boolean canJump = JumpGame.canJump(nums);
        boolean expected = false;
        Assert.assertEquals(expected, canJump);
    }
}
