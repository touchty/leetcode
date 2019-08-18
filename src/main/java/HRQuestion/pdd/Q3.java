package HRQuestion.pdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q3 {
    public List<List<Integer>> combinationSum(int target, int N, int upbound) {
        List<List<Integer>> res = new ArrayList<>();
        helper(1, target, res, new LinkedList<Integer>(), N, upbound);
        return res;
    }

    private void helper(int i, int target, List<List<Integer>> res, LinkedList<Integer> currList,
                        int N, int upbound) {
        if (target == 0 && currList.size() == N) {
            res.add(new LinkedList<>(currList));
            return;
        }
        if (target <= 0 || currList.size() >= N)
            return;

        for (int j = i; j <= upbound; j++) {
            currList.add(j);
            helper(j + 1, target - j, res, currList, N, upbound);
            currList.removeLast();
        }
    }


    public static void main(String[] args) {
        int t = 100;
        int N = 10;
        Q3 s = new Q3();
        List<List<Integer>> res = s.combinationSum(t, N, t);
        System.out.println(res.size());
    }
}
