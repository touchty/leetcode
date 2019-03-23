package array;

/**
 * 885. Spiral Matrix III
 * Medium
 * <p>
 * 66
 * <p>
 * 96
 * <p>
 * Favorite
 * <p>
 * Share
 * On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.
 * <p>
 * Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.
 * <p>
 * Now, we walk in a clockwise spiral shape to visit every position in this grid.
 * <p>
 * Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.)
 * <p>
 * Eventually, we reach all R * C spaces of the grid.
 * <p>
 * Return a list of coordinates representing the positions of the grid in the order they were visited.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: R = 1, C = 4, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1],[0,2],[0,3]]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: R = 5, C = 6, r0 = 1, c0 = 4
 * Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 */
public class SpiralMatrixIII {
    public static int[][] spiralMatrixIII(int R, int C, int r, int c) {
        int[][] res = new int[R * C][2];
        res[0] = new int[]{r, c};
        int x = 0, y = 1, n = 0, i = 0, tmp, j = 1;
        while (j < R * C) {
            r += x;
            c += y;
            i++;
            if (0 <= r && r < R && 0 <= c && c < C)
                res[j++] = new int[]{r, c};

            // turn to right
            // step length : 1, 1, 2, 2, 3, 3, 4, 4, ...
            // relationship between index and step length
            // i : 0 to n/2 + 1, (i steps in the same direction)
            if (i == n / 2 + 1) {
                i = 0;
                n++;
                tmp = x;
                x = y;
                y = -tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int R = 5, C = 6, r0 = 1, c0 = 4;
        int[][] res = SpiralMatrixIII.spiralMatrixIII(R, C, r0, c0);
        for (int[] point : res) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }
    }
}
