package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new LinkedList<>();
        dfs(candidates, target, 0, combinations, new LinkedList<Integer>(), new boolean[candidates.length]);
        return combinations;
    }

    private void dfs(int[] candidates, int target, int pos, List<List<Integer>> combinations,
                     LinkedList<Integer> list, boolean[] visited) {
        if (target == 0) {
            combinations.add(new LinkedList<>(list));
            return;
        }

        if (target < 0)
            return;

        for (int i = pos; i < candidates.length; i++) {
            if (i >= 1 && candidates[i] == candidates[i - 1] && !visited[i - 1])
                continue;
            if (candidates[i] > target)
                continue;
            list.add(candidates[i]);
            visited[i] = true;
            dfs(candidates, target - candidates[i], i + 1, combinations, list, visited);
            list.removeLast();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        LC40CombinationSumII solution = new LC40CombinationSumII();
        System.out.println(solution.combinationSum2(candidates, target));

    }
}
