package test;

// poj--1753--Flip Game（dfs好题）
// 翻转黑白方格， 使所有的方格为同一颜色
// 返回最小的步骤
/*
Description

Flip game is played on a rectangular 4x4 field with two-sided pieces placed on each of its 16 squares. One side of each piece is white and the other one is black and each piece is lying either it's black or white side up. Each round you flip 3 to 5 pieces, thus changing the color of their upper side from black to white and vice versa. The pieces to be flipped are chosen every round according to the following rules:
Choose any one of the 16 pieces.
Flip the chosen piece and also all adjacent pieces to the left, to the right, to the top, and to the bottom of the chosen piece (if there are any).

Consider the following position as an example:

bwbw
wwww
bbwb
bwwb
Here "b" denotes pieces lying their black side up and "w" denotes pieces lying their white side up. If we choose to flip the 1st piece from the 3rd row (this choice is shown at the picture), then the field will become:

bwbw
bwww
wwwb
wwwb
The goal of the game is to flip either all pieces white side up or all pieces black side up. You are to write a program that will search for the minimum number of rounds needed to achieve this goal.
Input

The input consists of 4 lines with 4 characters "w" or "b" each that denote game field position.
Output

Write to the output file a single integer number - the minimum number of rounds needed to achieve the goal of the game from the given position. If the goal is initially achieved, then write 0. If it's impossible to achieve the goal, then write the word "Impossible" (without quotes).
Sample Input

bwwb
bbwb
bwwb
bwww
Sample Output

4
Source
 */
public class FlipGame2D {
    boolean is(boolean[][] map) {
        boolean v = map[0][0];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != v)
                    return false;
            }
        }
        return true;
    }

    void flip(boolean[][] map, int r, int c) {
        int[][] dirs = {{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : dirs) {
            if (0 <= r + dir[0] && r + dir[0] < map.length && 0 <= c + dir[1] && c + dir[1] < map[0].length)
                map[r + dir[0]][c + dir[1]] = !map[r + dir[0]][c + dir[1]];
        }
    }

    boolean dfs(boolean[][] map, int r, int c, int step, int target) {
        if (r >= map.length || c >= map[0].length)
            return false;
        if (step == target) {
            return is(map);
        }

        flip(map, r, c);
        if (dfs(map, r + 1, c, step + 1, target) || dfs(map, r, c + 1, step + 1, target)) {
            return true;
        }
        flip(map, r, c);
        if (dfs(map, r + 1, c, step, target) || dfs(map, r, c + 1, step, target)) {
            return true;
        }
        return false;
    }

    int minStep(boolean[][] map) {
        int MAX = map.length * map[0].length;
        for (int i = 0; i <= MAX; i++) {
            if (dfs(map, 0, 0, 0, i))
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // steps : 0
        boolean[][] map = {{true, true, true, true}, {true, true, true, true}, {true, true, true, true}, {true, true, true, true}};
        FlipGame2D solution = new FlipGame2D();
        int steps = solution.minStep(map);
        System.out.println(steps);

        /*
        bwwb
        bbwb
        bwwb
        bwww
         */
        // steps : 4
        boolean[][] map1 = {{true,false,false,true}, {true,true, false,true}, {true,false,false,true}, {true,false,false,false}};
        int steps1 = solution.minStep(map1);
        System.out.println(steps1);

    }
}
