package graph;

import java.util.*;

/*
802. Find Eventual Safe States
Medium

319

48

Favorite

Share
In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

Note:

graph will have length at most 10000.
The number of edges in the graph will not exceed 32000.
Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */
public class FindEventualSafeStates {
    enum Color {
        White, Grey, Black;
        static String printColor(Color c) {
            if (c == Color.Black) {
                return ("Black Color.");
            }else if (c == Color.White) {
                return "White Color";
            }else if (c == Color.Grey) {
                return "Grey Color";
            }else {
                return "No match.";
            }
        }

        String printColor() {
            if (this == Color.Grey) {
                return "Greeeeeey!";
            }
            return this.toString();
        }
    }

    public List<Integer> eventualSafeNodes(int[][] a) {
        List<Integer> res = new ArrayList<>();
        if (a.length == 0) return res;

        Color[] color = new Color[a.length];
        Arrays.fill(color, Color.White);

        for (int i = 0; i < a.length; i++) {
            if (!dfs(i, a, color)) res.add(i);
        }

        return res;
    }


    boolean dfs(int cur, int[][] a, Color[] color) {
        if (color[cur] == Color.Grey) return true; // detect a circle
        if (color[cur] == Color.Black) return false; // no circle

        color[cur] = Color.Grey;
        for (int node : a[cur]) {
            if (dfs(node, a, color)) return true; // detect a circle
        }
        color[cur] = Color.Black; // no circle, set current node to BLACK

        return false;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        FindEventualSafeStates solution = new FindEventualSafeStates();
        List<Integer> list = solution.eventualSafeNodes(graph);
        System.out.println(list);
    }
}
