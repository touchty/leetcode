package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else map.remove(num);
        }

        Set<Integer> keys = map.keySet();
        if (keys.size() == 1) {
            Integer[] arr = new Integer[1];
            keys.toArray(arr);
            return arr[0];
        } else return -1;
    }

    public int singleNumberOpt(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int sum = 0;

        for (int num : nums) {
            sum ^= num;
        }
        return sum;
    }
}
