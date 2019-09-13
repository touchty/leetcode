package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, 0, target, res, new LinkedList<Integer>());
        return res;
    }

    private void helper(int[] candidates, int i, int target, List<List<Integer>> res, LinkedList<Integer> currList) {
        if (target == 0) {
            res.add(new LinkedList<>(currList));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (target >= candidates[j]) {
                currList.add(candidates[j]);
                helper(candidates, j, target - candidates[j], res, currList);
                currList.removeLast();
            }
        }
    }
}
