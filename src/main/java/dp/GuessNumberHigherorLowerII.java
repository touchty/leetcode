package dp;

public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        return DP(table, 1, n);
    }

    /*
    * For each number x in range[i~j]
    we do: result_when_pick_x = x + max{DP([i~x-1]), DP([x+1, j])}
    –> // the max means whenever you choose a number, the feedback is always
    bad and therefore leads you to a worse branch.
    then we get DP([i~j]) = min{xi, … ,xj}
    –> // this min makes sure that you are minimizing your cost.
    */
    private int DP(int[][] t, int s, int e){

        //t[s][e] means the min cost from s to e
        //
        if(s >= e) return 0;

        if(t[s][e] != 0) return t[s][e];

        int res = Integer.MAX_VALUE;

        for(int x=s; x<=e; x++){
            int tmp = x + Math.max(DP(t, s, x-1), DP(t, x+1, e));
            res = Math.min(res, tmp);
        }

        t[s][e] = res;

        return res;
    }

    private int dpRe(int[][] t, int s, int e){
        if (s >= e) return 0;

        if (t[s][e] != 0) return t[s][e];

        int result = Integer.MAX_VALUE;

        for (int x = s; x <= e; x++) {
            int temp = x + Math.max(dpRe(t, s, x - 1), dpRe(t, x + 1, e));
            result = Math.min(result, temp);
        }

        t[s][e] = result;
        return result;

    }

    public int getMoneyAmountRe(int n) {
        int[][] table = new int[n+1][n+1];
        return dpRe(table, 1, n);
    }

    //bottom up solution
    public int getMoneyAmountBottomUp(int n) {
        int[][] table = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int globalMin = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int localMax = k + Math.max(table[i][k - 1], table[k + 1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i + 1 == j ? i : globalMin;
            }
        }
        return table[1][n];
    }
}

