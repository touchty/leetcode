package pdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q3 {
    public List<List<Integer>> combinationSum(int target, int N) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, target, res, new LinkedList<Integer>(), N);
        return res;
    }

    private void helper(int i, int target, List<List<Integer>> res, LinkedList<Integer> currList,
                        int N) {
        if (target == 0 && currList.size() == N) {
            res.add(new LinkedList<>(currList));
            return;
        }
        if (target <= 0 || currList.size() >= N)
            return;

        for (int j = i; j <= target; j++) {
            currList.add(j);
            helper(j + 1, target - j, res, currList, N);
            currList.removeLast();
        }
    }


    public static void main(String[] args) {
        int t = 7;
        int N = 2;
        Q3 s = new Q3();
        List<List<Integer>> res = s.combinationSum(t, N);
        System.out.println(res);
    }
}
