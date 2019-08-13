package offer;

public class O49GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int N) {
        if (N <= 6)
            return N;
        int[] dp = new int[N];
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int v2 = 2 * dp[p2];
            int v3 = 3 * dp[p3];
            int v5 = 5 * dp[p5];
            int next = Math.min(Math.min(v2, v3), v5);
            dp[i] = next;
            if (next == v2)
                p2++;
            if (next == v3)
                p3++;
            if (next == v5)
                p5++;
        }
        return dp[N - 1];
    }

}
