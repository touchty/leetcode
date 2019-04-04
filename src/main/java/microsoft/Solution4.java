package microsoft;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    int max = Integer.MIN_VALUE;
    Map<String, Double> map = new HashMap<>();

    int honey(int[][] fls, int[][] hs, int[] source, int time) {
        for (int[] h: hs) {
            for (int[] f: fls) {
                String path = ""+h[0] + "-" + h[1] + "to" + f[0] + "-" + f[1];
                double len = Math.pow(f[0] - h[0], 2) + Math.pow(f[1] - h[1], 2);
                len = Math.sqrt(len);
                map.put(path, len);
            }
        }
        dfs(source, time, fls, hs, false, 0);
        return max;
    }

    void dfs(int[] currSource, double timeLeft, int[][] fls, int[][] hs, boolean hasF, int currHoney) {
        if (timeLeft < 0) {
            return;
        }
        if (hasF) {
            for (int i = 0; i < hs.length; i++) {
                int[] h = hs[i];
                double dist = Math.pow(currSource[0] - h[0], 2) + Math.pow(currSource[1] - h[1], 2);
                dist = Math.sqrt(dist);
                if (dist > timeLeft) continue;
                dfs(h, timeLeft - dist, fls, hs, false, currHoney + 1);
            }
        } else {
            for (int i = 0; i < fls.length; i++) {
                int[] h = fls[i];
                double dist = Math.pow(currSource[0] - h[0], 2) + Math.pow(currSource[1] - h[1], 2);
                dist = Math.sqrt(dist);
                if (dist > timeLeft) continue;
                dfs(h, timeLeft - dist, fls, hs, true, currHoney);
            }
        }
        max = Math.max(max, currHoney);
    }

    public static void main(String[] args) {
        int[][] fls = {{1, 0}, {3, 0}, {4, 0}};
        int[][] hs = {{2, 2}, {4,1}};
        int[] source = {0, 0};
        int time = 50;
        Solution4 solution = new Solution4();
        int res = solution.honey(fls, hs, source, time);
        System.out.println(res);
        long[][] dists = new long[fls.length][hs.length];

    }
}
