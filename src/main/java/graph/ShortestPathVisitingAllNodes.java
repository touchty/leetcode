package graph;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.Queue;

/*
847. Shortest Path Visiting All Nodes
https://leetcode.com/problems/shortest-path-visiting-all-nodes/
 */
public class ShortestPathVisitingAllNodes {
    public static int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int ans = (1 << graph.length) - 1; // 1111...1111 all nodes
        for (int i = 0; i < graph.length; i++) queue.offer(new int[]{i, 1 << i});
        int level = 0;
        boolean[][] visited = new boolean[graph.length][1 << graph.length];

        // Since we are using BFS, this is guranteed to be path with the lowest cost.
        //bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int[] cur = queue.poll();
                int node = cur[0];
                // state means "a certain path to a node"
                // if it is "111...111", we visit all nodes.
                int state = cur[1];
                if (state == ans) return level - 1;  // has visited all nodes
                for (int nei : graph[node]) {
                    int newState = state | (1 << nei); // try to visit one neighbor a time.
                    if (visited[nei][newState]) continue;
                    visited[nei][newState] = true;
                    queue.offer(new int[]{nei, newState});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        int path = ShortestPathVisitingAllNodes.shortestPathLength(graph);
        int expected = 4;
        Assert.assertEquals(expected, path);
    }
}
