package dp;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int matrix[][] = new int[n][n];
        for (int i=0; i < flights.length; i++) {
            matrix[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        //dp[k][i] stores min value from src to i, when k stops are reached
        int dp[][] = new int[K+1][n];
        for (int i = 0; i<n; i++) {
            if(matrix[src][i] > 0)
                dp[0][i] = matrix[src][i];
            else
                dp[0][i] = Integer.MAX_VALUE;
        }

        int k=1;
        for (; k <=K; k++) {
            boolean changed = false;
            for (int i=0; i <n; i++) {
                dp[k][i] = dp[k-1][i];  // CATCH: dp[k][i] = Integer.MAX_VALUE not work
                for (int j=0; j<n; j++) {
                    if (j != i) {
                        if ( dp[k-1][j] != Integer.MAX_VALUE && matrix[j][i] != 0) {
                            // update the lower cost
                            // if k+1 stops has lower cost
                            if (dp[k][i] > dp[k-1][j]+matrix[j][i]) {
                                dp[k][i] = dp[k-1][j]+matrix[j][i];
                                changed = true;
                            }
                        }
                    }
                }
            }
            if (!changed) break;
        }
        k = Integer.min(K, k);
        return  dp[k][dst] == Integer.MAX_VALUE ? -1: dp[k][dst];
    }
}
