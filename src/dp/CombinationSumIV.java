package dp;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        //target is in nums
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];

    }


    public int combinationSum4Rewrite(int[] nums, int target){
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length && i <= target; i++){
            //nums[i] = nums[i]
            dp[nums[i]] = 1;
        }

        for (int i = 1; i <= target; i++){
            for (int x : nums){
                if (i > x){
                    dp[i] += dp[i - x];
                }
            }
        }

        return dp[target];
    }

    public int combinationSum4Recursive(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSum4Recursive(nums, target - nums[i]);
            }
        }
        return res;
    }
}
