package dp;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1)
            return nums.length;

        int k = 1;

        // in case of starting with same set of numbers
        while(k<nums.length && nums[k] == nums[k-1]) k++;

        if(k == nums.length)
            return 1;

        int maxLen = 2;

        boolean isIncreasing = nums[k] > nums[k-1];

        for(int i=k+1; i<nums.length; i++) {
            if(isIncreasing && nums[i] < nums[i-1]) {
                maxLen++;
                isIncreasing = false;
            } else if(!isIncreasing && nums[i] > nums[i-1]) {
                maxLen++;
                isIncreasing = true;
            }
        }

        return maxLen;
    }

    public int wiggleMaxLengthRewrite(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        int k = 1;

        while (k < nums.length && nums[k] == nums[k - 1])
            k++;

        if (k == nums.length)
            return 1;

        int maxLen = 2;

        boolean isIncreased = nums[k] > nums[k - 1];

        for (int i = k + 1; i < nums.length; i++)
        {
            if (isIncreased && nums[i] < nums[ i -1]){
                maxLen++;
                isIncreased = false;
            }
            else {
                if (!isIncreased && nums[i] > nums[i - 1]){
                    maxLen++;
                    isIncreased=true;
                }
            }
        }

        return maxLen;
    }
}
