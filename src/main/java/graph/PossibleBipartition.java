package graph;

/*
886. Possible Bipartition
Medium

243

13

Favorite

Share
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group.

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] group = new int[N];
        boolean[][] graph = new boolean[N][N]; // 0: not visited; 1 : group 1; -1 : group -1;
        for (int[] dis : dislikes) {
            graph[dis[0] - 1][dis[1] - 1] = true;
            graph[dis[1] - 1][dis[0] - 1] = true;
        }

        for (int i = 0; i < N; i++) {
            if (group[i] == 0 && !dfs(graph, group, i, 1)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(boolean[][] graph, int[] group, int index, int g) {
        group[index] = g;
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i]) {
                if (group[i] == g) return false;
                if (group[i] == 0 && !dfs(graph, group, i, -g)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        int N = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition.possibleBipartition(N, dislikes));

        N = 3;
        dislikes = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println(possibleBipartition.possibleBipartition(N, dislikes));
    }

    class SolutionUF {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            int[] parents = new int[N + 1];
            for (int n = 1; n <= N; ++n)
                parents[n] = n;
            for (int i = 0; i < dislikes.length; ++i) {
                int p1 = dislikes[i][0];
                int p2 = dislikes[i][1];
                // we know dislikes[i][0] < dislikes[i][1], i.e. p1 < p2.
                // so we won't have the case when p1's parent is p2.
                if (parents[p2] == p2)
                    // p2 is not in any group yet. let's link p1 with p2.
                    parents[p2] = p1;
                    // p1 becomes p2's parent, which represents they are in 2 different groups.
                    // if p1's parent is p3, then p3 will be in the same group as p2.
                    // p3(group 1) <- p1(group 0) <- p2(group 1)
                else {
                    int[] uf1 = find(p1, parents);
                    int[] uf2 = find(p2, parents);
                    // if uf1[0]!=uf2[0], it means p1 and p2 are not linked yet.
                    if (uf1[0] == uf2[0] && uf1[1] == uf2[1]) // in the same union. should not be in the same group
                        return false;
                }
            }
            return true;
        }

        /*
        UNION FIND
                     1       ---0
                   /   \
                  2     3    ---1
                 / \
                4   5        ---0
         */
        private int[] find(int p, int[] parents) {
            int group = 0;
            while (parents[p] != p) {
                p = parents[p];
                group ^= 1;  // can be viewed as "level"
            }
            return new int[]{p, group};
        }
    }
}
