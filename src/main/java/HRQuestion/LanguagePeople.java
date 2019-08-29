package HRQuestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// pls[u, v]
// u能说v语言
// 人可以充当中间者进行翻译
// 还需要多少翻译机器才能全部沟通
public class LanguagePeople {
    int need(int n, int m, int k, int[][] pls) {
        return components(n, m, k, pls) - 1;
    }

    int components(int n, int m, int k, int[][] pls) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Set<Integer>> map1 = new HashMap<>();
        for (int[] pl : pls) {
            Set<Integer> set = map.getOrDefault(pl[0], new HashSet<>());
            set.add(pl[1]);
            map.put(pl[0], set);

            Set<Integer> set1 = map1.getOrDefault(pl[1], new HashSet<>());
            set1.add(pl[0]);
            map1.put(pl[1], set1);
        }

        boolean[] visited = new boolean[n + 1];
        int cs = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cs++;
                dfs(i, map, map1, visited);
            }
        }

        return cs;
    }

    private void dfs(int i, Map<Integer, Set<Integer>> map, Map<Integer, Set<Integer>> map1, boolean[] visited) {
        if (visited[i])
            return;
        visited[i] = true;

        if (!map.containsKey(i))
            return;

        for (int l : map.get(i)) {
            if (map1.containsKey(l))
                for (int j : map1.get(l)) {
                    dfs(j, map, map1, visited);
                }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int k = 3;
        int[][] pls = {{2, 3}, {3, 1}};
        LanguagePeople solution = new LanguagePeople();
        int res = solution.need(n, m, k, pls);
        System.out.println(res);
    }
}
