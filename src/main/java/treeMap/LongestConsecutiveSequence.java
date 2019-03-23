package treeMap;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        HashMap<Integer, Integer> consecutiveLength = new HashMap<>();

        for (int num : nums) {
            if (!consecutiveLength.containsKey(num)) {
                int prev = consecutiveLength.getOrDefault(num - 1, 0) + 1;
                longest = Math.max(longest, prev);
                consecutiveLength.put(num, prev);
            }
        }
        return longest;
    }

    public int longestConsecutiveV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int max = 1;
        int current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else if (nums[i] != nums[i - 1]) {
                current = 1;
            }
            max = Math.max(max, current);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};

        int longest = new LongestConsecutiveSequence().longestConsecutiveV2(nums);
        int expected = 4;
        System.out.println(longest);
        Assert.assertEquals(longest, expected);
        System.out.println("No Error.");
    }
}
