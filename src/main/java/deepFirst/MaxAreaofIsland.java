package deepFirst;

/*
* The idea is to count the area of each island using dfs. During the dfs, we set the value of each point
* in the island to 0. The time complexity is O(mn).
* */
public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) max_area = Math.max(max_area, AreaOfIsland(grid,i,j));
            }
        }
        return max_area;
    }

    public int AreaOfIsland(int[][] grid, int i, int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1,j) + AreaOfIsland(grid, i-1,j)
                    + AreaOfIsland(grid, i,j+1) +AreaOfIsland(grid, i,j-1);
        }
        return 0;
    }
}
