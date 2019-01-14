package dp;

/**
 * 174. Dungeon Game
 * Hard
 *
 * 548
 *
 * 12
 *
 * Favorite
 *
 * Share
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 *
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 *
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 *
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 *
 *
 *
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 *
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 */
public class DungeonGame {

    /*
    Analysis:
    It is easy to know that at grid P, since " at any point his health point drops to 0 or below, he dies immediately", the remaining health value should be at least 1,  that is, initialHealth + dungeon >= 1, we have initialHealth = max(1, 1 - dungeon[i][j]).  (Notice, at any grid, the initial health should be at least 1 (for example,  test case [1,0,0] require initial health 1 even though it has positive remaining health at grid[0][1] and grid[0][2])
    Similarly, to satisfy the initial health of dungeon[i][j], the initial health of dungeon[i-1][j] (or dungeon[i][j-1]) should be at least initialHealth[i-1][j] + dungeon[i-1][j] = initialHealth[i][j], that is, initialHealth[i][j] = initialHealth[i][j] - dungeon[i-1][j].
    In addition, if grid[i][j] can go both grid[i+1][j] and grid[i][j+1] to P,  we should choose a path with less initial health between grid[i+1][j] and grid[i][j+1] since it require less initial health of grid[i][j].
    We can simply code the solution by having the dynamic programming equations.
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] initialPower = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // last step
                if (i == m - 1 && j == n - 1) {
                    initialPower[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    initialPower[i][j] = Math.max(1, initialPower[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    initialPower[i][j] = Math.max(1, initialPower[i + 1][j] - dungeon[i][j]);
                } else {
                    initialPower[i][j] = Math.max(1, Math.min(initialPower[i][j + 1], initialPower[i + 1][j]) - dungeon[i][j]);
                }
            }

        }
        return initialPower[0][0];
    }
}
