package array;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static void dfs(int pos, List<Integer> list, List<List<Integer>> res, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = pos; i <= n; i++) {
            list.add(i);
            dfs(i + 1, list, res, n, k);
            list.remove(list.size() - 1);
        }
    }


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combine(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, new ArrayList<Integer>(), res, n, k);
        System.out.println(res);
    }
}
