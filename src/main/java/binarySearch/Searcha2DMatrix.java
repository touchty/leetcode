package binarySearch;

import java.util.Arrays;
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (n == 0) return false;

        int[] tmp = new int[m];
        for (int i = 0; i < m; i++){
            tmp[i] = matrix[i][0];
        }
        int row = Arrays.binarySearch(tmp, target);
        if (row >= 0) return true;
        if (row == -1) row = 0;
        else row = -1 * (row + 2);

        int pos = Arrays.binarySearch(matrix[row], target);
        if (pos >= 0) return true;
        else return false;

    }
}