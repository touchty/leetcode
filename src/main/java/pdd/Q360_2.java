package pdd;

import java.util.Arrays;

public class Q360_2 {

    int[] maxN(int[] num1, int[] num2, int n, int m) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (num1[i] + num2[j]) % m;
            }
        }

        int[] res = new int[n];
        boolean[] usedRows = new boolean[n];
        boolean[] usedCols = new boolean[n];
        int p = -1;
        int q = -1;
        int k = 0;
        while (k < n) {
            res[k] = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (usedRows[i] || usedCols[j])
                        continue;
                    if (res[k] < matrix[i][j]) {
                        p = i;
                        q = j;
                        res[k] = matrix[i][j];
                    }
                }
            }
            usedRows[p] = true;
            usedCols[q] = true;
            k++;
        }

        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[] num1 = {4, 4, 1, 1, 1};
        int[] num2 = {4, 3, 0, 1, 2};
        Q360_2 solution = new Q360_2();
        int[] res = solution.maxN(num1, num2, n, m);
        StringBuilder builder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            builder.append(res[i]).append(" ");
        }
        System.out.println(builder.toString());
    }
}
