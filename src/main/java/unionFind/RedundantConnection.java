package unionFind;

/*
684. Redundant Connection
Medium

554

183

Favorite

Share
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
Example 2:
Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parents[i] = i;
        }

        for (int[] edge: edges) {
            int s = edge[0];
            int t = edge[1];
            if (find(parents, s) != find(parents, t)) {
                parents[find(parents, s)] = parents[find(parents, t)];
            }
            else{
                return edge;
            }
        }
        return new int[]{-1, -1};
    }

    int find(int[] parents, int n) {
        if (n != parents[n]) {
            parents[n] = find(parents, parents[n]);
        }
        return parents[n];
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        RedundantConnection solution = new RedundantConnection();
        int[] edge = solution.findRedundantConnection(edges);
        System.out.println(edge[0] + ", " + edge[1]);
    }
}
