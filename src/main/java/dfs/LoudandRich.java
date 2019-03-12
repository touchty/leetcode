package dfs;

import java.util.*;

/*
851. Loud and Rich
Medium

140

164

Favorite

Share
In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money, and different levels of
quietness.
For convenience, we'll call the person with label x, simply "person x".
We'll say that richer[i] = [x, y] if person x definitely has more money than person y.  Note that richer may only be a
subset of valid observations.
Also, we'll say quiet[x] = q if person x has quietness q.
Now, return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of
quiet[y]), among all people who definitely have equal to or more money than person x.
*/
public class LoudandRich {
    HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
    int res[];

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        for (int i = 0; i < n; ++i) richer2.put(i, new ArrayList<Integer>());
        for (int[] v : richer) richer2.get(v[1]).add(v[0]);
        res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) dfs(i, quiet);
        return res;
    }

    int dfs(int i, int[] quiet) {
        if (res[i] >= 0) return res[i];
        res[i] = i;
        for (int j : richer2.get(i)) if (quiet[res[i]] > quiet[dfs(j, quiet)]) res[i] = res[j];
        return res[i];
    }

    public static void main(String[] args) {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        LoudandRich loudandRich = new LoudandRich();
        int[] res = loudandRich.loudAndRich(richer, quiet);
        for (int i : res)
            System.out.println(i);
    }
}
