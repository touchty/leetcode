package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
40. Combination Sum II
Medium

783

42

Favorite

Share
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, target, res, new LinkedList<Integer>());
        return res;
    }

    private void helper(int[] candidates, int i, int target, List<List<Integer>> res, LinkedList<Integer> currList) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<>(currList));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            /* [1 2 2 5]
                  ^
               [1 2 2 5]
                  ^ ^
                  */
            if (j > i && candidates[j] == candidates[j - 1]) continue;
            if (target >= candidates[j]) {
                currList.add(candidates[j]);
                helper(candidates, j + 1, target - candidates[j], res, currList);
                currList.removeLast();
            }
        }
    }
}
