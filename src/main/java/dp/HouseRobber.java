package dp;

public class HouseRobber
{
    public static int rob(int[] nums)
    {
        int ifRobbedPrevious = 0; 	// max monney can get if rob current house
        int ifDidntRobPrevious = 0; // max money can get if not rob current house

        // We go through all the values, we maintain two counts, 1) if we rob this cell, 2) if we didn't rob this cell
        for(int i=0; i < nums.length; i++)
        {
            // If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
            int currRobbed = ifDidntRobPrevious + nums[i];

            // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
            int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious);

            // Update values for the next round
            ifDidntRobPrevious  = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
    }

    public static int robRewrite(int[] nums){
        int ifRobbedPrevious = 0;
        int ifNotRobbedPrevious = 0;

        for (int i = 0; i < nums.length; i++)
        {
            //Rob current house
            int currRobbed = ifNotRobbedPrevious + nums[i];

            //Do not rob current house
            int currNotRobbed = Math.max(ifNotRobbedPrevious, ifRobbedPrevious);

            //Update values for the next round
            ifNotRobbedPrevious = currNotRobbed;
            ifRobbedPrevious = currRobbed;
        }

        return Math.max(ifNotRobbedPrevious, ifRobbedPrevious);
    }

    public int robTwoArr(int[] nums){
        int[][] dp = new int[nums.length + 1][2];

        for (int i = 1; i < dp.length; i++)
        {
            // dp[][0] : if not rob current house
            // d[][1] : if rob current house

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }

        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public int robOpt(int[] nums){
        int robCurr = 0;
        int notRobCurr = 0;

        for (int m : nums){
            int robM = notRobCurr + m;
            int notRobM = Math.max(robCurr, notRobCurr);

            // update
            robCurr = robM;
            notRobCurr = notRobM;
        }

        return Math.max(robCurr, notRobCurr);
    }
}
