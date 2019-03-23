package dp;

import java.util.HashMap;
import java.util.Map;

//Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous
// subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // map 0:-1
        // when nums[0] + nums[1] + .. + nums[t] == n*k
        //map.put(remainder , position)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, -1);
        }};
        ;
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0) runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1) return true;  // length of subarray is greater than 2
            } else map.put(runningSum, i);
        }
        return false;
    }
}
