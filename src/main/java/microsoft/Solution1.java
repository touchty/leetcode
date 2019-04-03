package microsoft;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    int N ; int P; int X;
    int ways(int N, int P, int X) {
        this.N = N;
        this.P = P;
        this.X = X;
        List<List<Integer>> res = new ArrayList<>();
        dfs(P, 0, new ArrayList<Integer>(), res);
        return res.size();
    }

    void dfs(int curr, int i, List<Integer> path, List<List<Integer>> res) {
        if (path.size() > X) return;
        if (curr == P && path.size() > 0){
            res.add(new ArrayList<>(path));
        }
        for (int j = 1; j <= N; j++) {
            if (j == curr) continue;
            if (curr % j == 0 || j % curr == 0) {
                path.add(j);
                dfs(j, i+1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int N = 3;
        int P = 2;
        int X = 2;
        int ways = 0;
        /*ways = solution1.ways(N, P, X);
        System.out.println(ways);*/

        N = 3;
        P = 2;
        X = 4;
        ways = solution1.ways(N, P, X);
        System.out.println(ways);
    }
}
