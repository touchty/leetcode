package graph;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
827. Making A Large Island
Hard

234

9

Favorite

Share
In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:

Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: [[1, 1], [1, 0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
Example 3:

Input: [[1, 1], [1, 1]]
Output: 4
Explanation: Can't change any 0 to 1, only one island with area = 4.
 */

public class MakingALargeIsland {
    public int largestIsland(int[][] grid) {
        int res = 0;
        ArrayList<Integer> sizes = new ArrayList<>(); // sentinel values; colors start from 2.
        sizes.add(0);
        sizes.add(0);
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                if (grid[i][j] == 1) sizes.add(paint(i, j, sizes.size(), grid));
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[i].length; ++j)
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>(4);
                    set.add(get(i, j + 1, grid));
                    set.add(get(i, j - 1, grid));
                    set.add(get(i - 1, j, grid));
                    set.add(get(i + 1, j, grid));
                    if (set.size() == 0) break;
                    int sum = 0;
                    for (int clr : set) {
                        sum += sizes.get(clr); // all four adjacent are combined, including 0.
                    }
                    res = Math.max(res, 1 + sum);
                }
        return res == 0 ? grid.length * grid[0].length : res;
    }

    int get(int i, int j, int[][] grid) {
        return (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) ? 0 : grid[i][j];
    }

    int paint(int i, int j, int clr, int[][] grid) {
        if (get(i, j, grid) != 1) return 0;
        grid[i][j] = clr;
        return 1 + paint(i + 1, j, clr, grid) + paint(i - 1, j, clr, grid) +
                paint(i, j + 1, clr, grid) + paint(i, j - 1, clr, grid);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0}, {0, 1}};
        int res = 0;
        MakingALargeIsland solution = new MakingALargeIsland();
        /*res = solution.largestIsland(grid);
        System.out.println(res);

        grid = new int[][]{{0, 0}, {0, 0}};
        res = solution.largestIsland(grid);
        System.out.println(res);

        grid = new int[][]{{1, 1}, {1, 1}};
        res = solution.largestIsland(grid);
        System.out.println(res);

        grid = new int[][]{{1}};
        res = solution.largestIsland(grid);
        System.out.println(res);

        grid = new int[][]{{0}};
        res = solution.largestIsland(grid);
        System.out.println(res);

        grid = new int[][]{{1, 0, 0, 1, 1}, {1, 0, 0, 1, 0}, {1, 1, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 1, 0}};
        res = solution.largestIsland(grid);
        System.out.println(res);*/

        /*grid = new int[][]{{0, 0}, {1,1}};
        res = solution.largestIsland(grid);
        System.out.println(res);*/

        grid = new int[][]{{0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 0, 0}, {0, 1, 1, 1, 1, 0, 0}};
        res = solution.largestIsland(grid);
        int expected = 18;
        Assert.assertEquals(expected, res);
    }
}
