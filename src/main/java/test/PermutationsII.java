package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47. Permutations II
Medium

931

42

Favorite

Share
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backTracing(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void backTracing(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j] || (!used[j] && j > 0 && nums[j - 1] == nums[j] && !used[j - 1]))
                continue;
            used[j] = true;
            list.add(nums[j]);
            backTracing(nums, list, res, used);
            used[j] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1};
        PermutationsII s = new PermutationsII();
        List<List<Integer>> res = s.permuteUnique(nums);
        System.out.println(res);
    }
}
