package unionFind;

/*
685. Redundant Connection II
Hard

408

140

Favorite

Share
In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.

The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.

Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given directed graph will be like this:
  1
 / \
v   v
2-->3
Example 2:
Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
Output: [4,1]
Explanation: The given directed graph will be like this:
5 <- 1 -> 2
     ^    |
     |    v
     4 <- 3
 */
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        // step 1, check whether there is a node with two parents
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[]{edges[i][0], edges[i][1]};
                can1 = new int[]{parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        // step 2, union find
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            // Now every node only has 1 parent, so root of v is implicitly v
            // circle is found
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father;
        }
        return can2;
    }

    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
        /*int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        RedundantConnectionII solution = new RedundantConnectionII();
        int[] edge = solution.findRedundantDirectedConnection(edges);
        int[] expected = {2, 3};
        Assert.assertArrayEquals(expected, edge);*/

        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}};
        RedundantConnectionII solution = new RedundantConnectionII();
        int[] edge = solution.findRedundantDirectedConnection(edges);
        int[] expected = {4, 1};
    }
}
