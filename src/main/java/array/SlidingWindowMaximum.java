package array;

import java.util.TreeMap;

public class SlidingWindowMaximum {
    /*Map<Integer, Integer> map = new HashMap<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return nums;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length && i < k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = max > nums[i] ? max : nums[i];
        }

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k; i++){
            res[i] = max;
            map.put(nums[i], map.get(nums[i]) - 1); // delete i
            map.put(nums[i + k], map.getOrDefault(nums[i + k], 0) + 1); // add i + k
            max = max > nums[i + k] ? max : nums[i + k];
            if (map.getOrDefault(max, 0) == 0) {
                max = Integer.MIN_VALUE;
                for (int j = i + 1; j <= i + k; j++){
                    max = max > nums[j] ? max : nums[j];
                }
            }
        }
        max = Integer.MIN_VALUE;
        for (int p = nums.length - k; p < nums.length; p++){
            max = max > nums[p] ? max : nums[p];
        }
        res[nums.length - k] = max;

        return res;
    }*/

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1)
            return nums;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length && i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = max > nums[i] ? max : nums[i];
        }

        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k; i++) {
            if (map.get(nums[i]) == 1) // delete i
                map.remove(nums[i]);
            else
                map.put(nums[i], map.get(nums[i]) - 1);

            res[i] = max;
            map.put(nums[i + k], map.getOrDefault(nums[i + k], 0) + 1); // add i + k
            max = max > nums[i + k] ? max : nums[i + k];
            if (!map.containsKey(max)) {
                max = map.lastKey();
            }
        }
        max = Integer.MIN_VALUE;
        for (int p = nums.length - k; p < nums.length; p++) {
            max = max > nums[p] ? max : nums[p];
        }
        res[nums.length - k] = max;

        return res;
    }

    public int[] maxSlidingWindowOpt(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        int maxIndex = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        result[0] = nums[maxIndex];
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
            if (maxIndex <= i - k) {
                maxIndex = i - k + 1;
                for (int j = i - k + 1; j <= i; j++) {
                    if (nums[j] > nums[maxIndex]) maxIndex = j;
                }
            }
            result[index++] = nums[maxIndex];
        }
        return result;
    }
}
