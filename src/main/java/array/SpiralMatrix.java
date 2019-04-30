package array;

import java.util.ArrayList;
import java.util.List;

/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
/*
 * U R
 * L D
 * */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        int u = 0;
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (true) {
            // up edge
            for (int column = l; column <= r; column++) {
                result.add(matrix[u][column]);
            }
            if (++u > d) break;

            // right edge
            for (int row = u; row <= d; row++) {
                result.add(matrix[row][r]);
            }
            if (--r < l) break;

            // bottom edge
            for (int column = r; column >= l; column--) {
                result.add(matrix[d][column]);
            }
            if (--d < u) break;

            // left edge
            for (int row = d; row >= u; row--) {
                result.add(matrix[row][l]);
            }
            if (++l > r) break;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix solution = new SpiralMatrix();
        List<Integer> list = solution.spiralOrder(matrix);
        System.out.println(list);
    }
}
