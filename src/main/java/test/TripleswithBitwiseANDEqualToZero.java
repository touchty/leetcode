package test;

import java.util.*;

// LC 982. Triples with Bitwise AND Equal To Zero
// 三者的与运算的结果为零

public class TripleswithBitwiseANDEqualToZero {
    public int countTriplets(int[] A) {
        int[] res = new int[]{0};
        backTracking(A, new ArrayList<Integer>(), res);
        return res[0];
    }

    private void backTracking(int[] A, List<Integer> list, int[] res) {
        if (list.size() == 3) {
            int andVal = list.get(0);
            for (int i : list) {
                andVal = andVal & i;
            }
            if (andVal == 0)
                res[0]++;
            return;
        }

        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
            backTracking(A, list, res);
            list.remove(list.size() - 1);
        }
    }


    public int countTripletsDP(int[] A) {
        int N = 1 << 16, M = 3;
        int[][] dp = new int[M + 1][N];
        dp[0][N - 1] = 1;
        for (int i = 0; i < M; i++) {
            for (int k = 0; k < N; k++) {
                for (int a : A) {
                    dp[i + 1][k & a] += dp[i][k];
                }
            }
        }
        return dp[M][0];
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 3};
        TripleswithBitwiseANDEqualToZero solution = new TripleswithBitwiseANDEqualToZero();
        int res = solution.countTriplets(A);
        System.out.println(res);
    }
}
