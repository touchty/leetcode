package graph;

import java.util.*;

/*
864. Shortest Path to Get All Keys
Hard

176

4

Favorite

Share
We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.

We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.

For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.



Example 1:

Input: ["@.a.#","###.#","b.A.B"]
Output: 8
Example 2:

Input: ["@..aA","..B#.","....b"]
Output: 6
 */
public class ShortestPathtoGetAllKeys {
    // state or the grid visited. current position + keys acquired.
    // it allows enter the same position unless the keys acquired are not identical.
    class State {
        int keys, i, j;

        State(int keys, int i, int j) {
            this.keys = keys; // using bit as the keys acquired, (111...111) means get all keys
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                // total keys
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y); // start point
        Queue<State> q = new LinkedList<>(); // bfs
        Set<String> visited = new HashSet<>(); // flag
        visited.add(0 + " " + x + " " + y);
        q.offer(start); // bfs start point
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int step = 0; // min steps
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State cur = q.poll();
                if (cur.keys == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = cur.i + dir[0];
                    int j = cur.j + dir[1];
                    int keys = cur.keys;
                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            keys |= 1 << (c - 'a'); // get a key
                        }
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(keys + " " + i + " " + j)) {
                            visited.add(keys + " " + i + " " + j);
                            q.offer(new State(keys, i, j)); // next breadth
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] grid = {"@.a.#",
                         "##b.#",
                         "b.A.B"};
        ShortestPathtoGetAllKeys solution = new ShortestPathtoGetAllKeys();
        int path = solution.shortestPathAllKeys(grid);
        int expected = 8;
        System.out.println(path);
        //Assert.assertEquals(expected, path);

        ShortestPathtoGetAllKeysRewrite s = new ShortestPathtoGetAllKeysRewrite();
        int path1 = s.shortestPathAllKeys(grid);
        System.out.println(path1);
    }
}

class ShortestPathtoGetAllKeysRewrite {
    class State {
        int keys, i, j;

        State(int keys, int i, int j) {
            this.keys = keys; // using bit as the keys acquired, (111...111) means get all keys
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        int x = -1, y = -1, m = grid.length, n = grid[0].length(), max = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    x = i;
                    y = j;
                }
                // total keys
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(c - 'a' + 1, max);
                }
            }
        }
        State start = new State(0, x, y); // start point
        Queue<State> q = new LinkedList<>(); // bfs
        Set<String> visited = new HashSet<>(); // flag
        visited.add(0 + " " + x + " " + y);
        q.offer(start); // bfs start point
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                State curr = q.poll();
                x = curr.i;
                y = curr.j;
                int keys = curr.keys;
                if (keys == (1 << max) - 1)
                    return steps;
                for (int[] dir : dirs) {
                    int nextx = x + dir[0];
                    int nexty = y + dir[1];
                    if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n) {
                        char c = grid[nextx].charAt(nexty);
                        if (c == '#')
                            continue;
                        if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) // no certain key
                            continue;
                        if (c >= 'a' && c <= 'f') {
                            keys |= (1 << (c -'a'));
                        }
                        if (!visited.contains(keys+" " + nextx+" " + nexty)){
                            q.offer(new State(keys, nextx, nexty));
                            visited.add(keys+" " + nextx+" " + nexty);
                        }
                    }
                }
            }
            steps++; // every layer increase the distance by one.
        }
        return -1;
    }
}
