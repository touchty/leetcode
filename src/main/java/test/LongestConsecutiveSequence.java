package test;

import java.util.HashMap;
import java.util.Map;
//128. Longest Consecutive Sequence

// 最长连续相邻子序列
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//Your algorithm should run in O(n) complexity.
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxL = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue; // 已经被处理过， 没有增长的可能

            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int newL = 1 + left + right;

            map.put(n, newL);

            // 只可能在两端进行增长
            map.put(n - left, newL);
            map.put(n + right, newL);

            // 更新最长的连续数组长度
            maxL = Math.max(maxL, newL);
        }
        return maxL;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 1};
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int sequenceLen = solution.longestConsecutive(nums);
        System.out.println(sequenceLen);
    }
}
