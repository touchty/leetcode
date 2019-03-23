package dp;

public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];

        for (int num : nums) {
            values[num] += num;
        }

        //take i or not take i (skip)
        int take = 0;
        int skip = 0;
        for (int i = 0; i < n; i++) {
            int takei = skip + values[i];  // we must skip i
            int skipi = Math.max(skip, take);  // either taking i-1 or skipping i-1
            take = takei;  // update
            skip = skipi;  // update
        }

        return Math.max(take, skip);

    }
}
