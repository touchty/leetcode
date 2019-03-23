package binarySearch;

import java.util.Arrays;

public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        if (matrix[0] == null || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        // low boundary of rows
        int[] lastColumn = new int[m];
        for (int i = 0; i < m; i++) {
            lastColumn[i] = matrix[i][n - 1];
        }
        int row_lo = Arrays.binarySearch(lastColumn, target);
        if (row_lo >= 0) return true;
        row_lo = -(row_lo + 1);

        // high boundary of rows
        int[] firstColumn = new int[m];
        for (int i = 0; i < m; i++) {
            firstColumn[i] = matrix[i][0];
        }
        int row_hi = Arrays.binarySearch(firstColumn, target);
        if (row_hi >= 0) return true;
        if (row_hi == -1) return false;
        row_hi = -(row_hi + 2);

        //search for target in possible row range
        for (int r = row_lo; r <= row_hi; r++) {
            int pos = Arrays.binarySearch(matrix[r], target);
            if (pos >= 0) return true;
        }

        return false;
    }

    public boolean searchMatrixNoBinarSearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] < target)
                i++;
            else if (matrix[i][j] > target)
                j--;
            else
                return true;
        }
        return false;

    }
}
