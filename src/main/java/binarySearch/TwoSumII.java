package binarySearch;

import java.util.HashMap;

public class TwoSumII {
    private HashMap<Integer, Integer> map = new HashMap<>();
    int[] result = new int[2]; // store the two indexes adding to target

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            int expected = target - val;
            if (map.containsKey(expected)) {
                result[0] = map.get(expected) + 1;
                result[1] = val;
            } else map.put(val, i);
        }

        return result;
    }
}
