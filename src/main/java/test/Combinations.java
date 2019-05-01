package test;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    private void dfs(List<List<Integer>> res, ArrayList<Integer> list, int i, int n, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            dfs(res, list, j + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations solution = new Combinations();
        List<List<Integer>> res = solution.combine(n, k);
        System.out.println(res.size());
        System.out.println(res);
    }
}
