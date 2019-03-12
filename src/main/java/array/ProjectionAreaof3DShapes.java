package array;

/*
883. Projection Area of 3D Shapes
Easy

124

413

Favorite

Share
On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.

Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).

Now we view the projection of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.

Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.



Example 1:

Input: [[2]]
Output: 5
Example 2:

Input: [[1,2],[3,4]]
Output: 17
Explanation:
Here are the three projections ("shadows") of the shape made with each axis-aligned plane.
 */
public class ProjectionAreaof3DShapes {
    public static int projectionArea(int[][] grid) {
        int res = 0, n = grid.length;
        // yz projection area
        for (int i = 0, v = 0; i < n; ++i, res += v, v = 0)
            for (int j = 0; j < n; ++j)
                v = Math.max(v, grid[i][j]);
        //  xz projection area
        for (int j = 0, v = 0; j < n; ++j, res += v, v = 0)
            for (int i = 0; i < n; ++i)
                v = Math.max(v, grid[i][j]);
        // xy bottom area
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] > 0) res++;
        return res;
    }
    public static void main(String[] args) {
        /*
        y
        ^
        |
        |
        |1|0|
        |2|0|____________________> x
         */


        int[][] grid = {{2, 0},{1, 0}};
        System.out.println(projectionArea(grid));
    }
}
