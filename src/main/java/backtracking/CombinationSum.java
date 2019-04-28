package backtracking;

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

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int t = 8;
        CombinationSum s = new CombinationSum();
        List<List<Integer>> res = s.combinationSum(candidates, t);
        System.out.println(res);

        /*LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list.removeLast();
        System.out.println(list);*/
    }
}
