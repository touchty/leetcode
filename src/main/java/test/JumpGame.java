package test;

public class JumpGame {
    public boolean canJump(int[] nums) {
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

}
