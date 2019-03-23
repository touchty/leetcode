package dfs;

import java.util.*;

public class IncreasingSubsequences {
    /*
     public List<List<Integer>> findSubsequences(int[] a) {
        Set<List<Integer>> r = new HashSet<>();
        find(0, a, new LinkedList<>(), r);
        return new ArrayList<>(r);
    }

    void find(int start, int[] a, LinkedList<Integer> list, Set<List<Integer>> r) {
        if (list.size() >= 2)
            r.add(new ArrayList<>(list));
        for (int i = start; i < a.length; i++)
            if (list.isEmpty() || list.getLast() <= a[i]) {
                list.add(a[i]);
                find(i + 1, a, list, r);
                list.removeLast();
            }
    }
    * */

    public List<List<Integer>> findSubsequences(int[] a) {
        Set<List<Integer>> r = new HashSet<>();
        find(0, a, new LinkedList<Integer>(), r);
        return new ArrayList<>(r);
    }

    void find(int start, int[] a, LinkedList<Integer> list, Set<List<Integer>> r) {
        if (list.size() >= 2)
            r.add(new ArrayList<>(list));

        for (int i = start; i < a.length; i++)
            if (list.isEmpty() || list.getLast() <= a[i]) {
                list.add(a[i]);
                find(i + 1, a, list, r);
                list.removeLast();
            }
    }
}
