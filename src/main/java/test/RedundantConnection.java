package test;

// 最小生成树
// 684. Redundant Connection
// 无向图
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            int p1 = findP(parents, edge[0]);
            int p2 = findP(parents, edge[1]);
            if (p1 != p2) {
                parents[p1] = p2;
            } else {
                return edge;
            }
        }
        return new int[]{-1, -1};
    }

    int findP(int[] parents, int n) {
        if (parents[n] == n) {
            return n;
        }
        parents[n] = findP(parents, parents[n]);
        return parents[n];
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        RedundantConnection redundantConnection = new RedundantConnection();
        int[] edge = redundantConnection.findRedundantConnection(edges);
        System.out.println(edge[0] + ", " + edge[1]);
    }
}
