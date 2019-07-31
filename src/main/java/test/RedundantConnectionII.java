package test;

// 最小生成树
// LC 685. Redundant Connection II
// 仅有一条额外的边，把该边找到
// 有向图
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[]{edges[i][0], edges[i][1]};
                can1 = new int[]{parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            }
            int child = edges[i][1], father = edges[i][0];
            if (root(parent, father) == child) {
                if (can1[0] == -1) {
                    return edges[i]; // pure circle

                }
                return can1; // circle and a 2 indegree node
            }
            parent[child] = father;
        }
        return can2; // no circle, just a 2 indegree node
    }

    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}, {4, 3}};
        RedundantConnectionII solution = new RedundantConnectionII();
        int[] prun = solution.findRedundantDirectedConnection(edges);
        System.out.println(prun[0] + ", " + prun[1]);
    }
}
