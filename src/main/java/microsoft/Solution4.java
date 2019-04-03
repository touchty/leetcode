package microsoft;

public class Solution4 {
    int max = Integer.MIN_VALUE;

    int honey(int[][] fls, int[][] hs, int[] source, int time) {
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
        int[][] hs = {{2, 0}};
        int[] source = {0, 0};
        int time = 5;
        Solution4 solution = new Solution4();
        int res = solution.honey(fls, hs, source, time);
        System.out.println(res);
    }
}
