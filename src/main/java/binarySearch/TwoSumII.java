package binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
1. Two Sum
Easy

10235

335

Favorite

Share
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSumII {
    // return the index of the two operands
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    // return the value of the two operand
    public int[] twoSumVal(int[] numbers, int target) {
        Arrays.sort(numbers);
        int start = 0, end = numbers.length - 1;
        //find the index of two numbers
        int[] res = new int[2];

        //find value of two nums
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else {
                res[0] = numbers[start];
                res[1] = numbers[end];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSumII solution = new TwoSumII();
        int[] values = solution.twoSumVal(nums, target);
        for (int v : values) {
            //System.out.println(v);
        }

        int[] indexes = solution.twoSum(nums, target);
        for (int idx : indexes) {
            System.out.println(idx);
        }
    }
}
