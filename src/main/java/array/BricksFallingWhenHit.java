package array;

/*
803. Bricks Falling When Hit
Hard

271

88

Favorite

Share
We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.

We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.

Return an array representing the number of bricks that will drop after each erasure in sequence.

Example 1:
Input:
grid = [[1,0,0,0],[1,1,1,0]]
hits = [[1,0]]
Output: [2]
Explanation:
If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
Example 2:
Input:
grid = [[1,0,0,0],[1,1,0,0]]
hits = [[1,1],[1,0]]
Output: [0,0]
Explanation:
When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.  Note that the erased brick (1, 0) will not be counted as a dropped brick.


Note:

The number of rows and columns in the grid will be in the range [1, 200].
The number of erasures will not exceed the area of the grid.
It is guaranteed that each erasure will be different from any other erasure, and located inside the grid.
An erasure may refer to a location with no brick - if it does, no bricks drop.
 */


// Solution:
// https://leetcode.com/problems/bricks-falling-when-hit/discuss/119829/Python-Solution-by-reversely-adding-hits-bricks-back
public class BricksFallingWhenHit {
    private static int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        int len = hits.length;
        int[] res = new int[len];

        for (int[] hit : hits) {
            int x = hit[0];
            int y = hit[1];
            grid[x][y]--;
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(grid, 0, j); // set the grid connecting to the top to 2
            }
        }

        // the order is from the last hit to the first hit
        for (int i = len - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            grid[x][y]++;
            if (grid[x][y] == 0) continue; // not a brick
            if (!connectedToTop(grid, x, y)) continue;// already been dropped by some previous hit
            res[i] = dfs(grid, x, y) - 1; //not count the hitted one...
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        //set grid[i][j] from 1 to 2, and cnt the total number of connected spots...
        int m = grid.length, n = grid[0].length;
        grid[i][j] = 2;
        int cnt = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) continue;
            cnt += dfs(grid, x, y);
        }
        return cnt;
    }

    private boolean connectedToTop(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (x == 0) return true;
        for (int[] dir : dirs) {
            int i = x + dir[0];
            int j = y + dir[1];
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 2)
                continue; // after the first dfs, all connecting bricks are set to 2
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {1, 1, 1, 0}};
        int[][] hits = {{1, 0}};
        BricksFallingWhenHit solution = new BricksFallingWhenHit();
        int[] droppings = solution.hitBricks(grid, hits);
        for (int dropping : droppings)
            System.out.println(dropping);
    }
}
