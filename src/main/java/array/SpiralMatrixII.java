package array;

import java.util.ArrayList;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int u = 0;
        int d = n - 1;
        int l = 0;
        int r = n - 1;
        int element = 1; // 1, 2, 3, ..., n^2
        while (true){
            // up
            for (int column = l; column <= r; column++) {
                matrix[u][column] = element++;
            }
            if (++u > d) break;

            // right
            for (int row = u; row <= d; row++) {
                matrix[row][r] = element++;
            }
            if (--r < l) break;

            // bottom
            for (int column = r; column >= l; column--) {
                matrix[d][column] = element++;
            }
            if (--d < u) break;

            // left
            for (int row = d; row >= u; row--) {
                matrix[row][l] = element++;
            }
            if (++l > r) break;
        }
        return matrix;
    }
}
