package test;

import java.util.HashMap;

public class SubarraySumEqualsK {
    // 148ms
    int subarraySum(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length == 0)
            return res;
        int[] sums = new int[nums.length + 1];
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
        for (int i = 0; i < sums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sums[i] - sums[j] == k)
                    res++;
            }
        }
        return res;
    }

    // 15ms
    int subarraySumOpt(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length == 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = nums[i] + sums[i];
            res += map.getOrDefault(sums[i + 1] - k, 0);
            map.put(sums[i + 1], map.getOrDefault(sums[i + 1], 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int[] nums = {1,1,1};
        int K = 2;
        int res = s.subarraySumOpt(nums, K);
        System.out.println(res);


    }
}
