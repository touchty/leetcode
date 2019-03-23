package dp;

public class HouseRobberII {
    private int robInRange(int[] nums, int lo, int hi) {
        int robCurr = 0;
        int notRobCurr = 0;

        for (int i = lo; i <= hi; i++) {
            int robI = notRobCurr + nums[i];
            int notRonI = Math.max(robCurr, notRobCurr);

            robCurr = robI;
            notRobCurr = notRonI;
        }
        return Math.max(robCurr, notRobCurr);
    }

    public int rob(int[] nums) {

        //  particular case
        if (nums.length == 1) return nums[0];

        int sum1 = robInRange(nums, 0, nums.length - 2);

        int sum2 = robInRange(nums, 1, nums.length - 1);

        return Math.max(sum1, sum2);
    }
}
