package tree;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 * Example 1:
 * Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation:
 * Here is a diagram of the given tree:
 * 0
 * / \
 * 1   2
 * /|\
 * 3 4 5
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 * Note: 1 <= N <= 10000
 */
public class SumOfDistancesInTree {
    int[] res;
    int[] count;
    ArrayList<HashSet<Integer>> tree;
    int n;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        n = N;
        for (int i = 0; i < N; ++i) tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        sumDistancesToRoot(0, new HashSet<Integer>());
        otherSumsBasedOnRoot(0, new HashSet<Integer>());
        return res;
    }

    void sumDistancesToRoot(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                sumDistancesToRoot(i, seen);
                count[root] += count[i];
                res[root] += res[i] + count[i];
            }
        count[root]++;
    }


    void otherSumsBasedOnRoot(int root, HashSet<Integer> seen) {
        seen.add(root);
        for (int i : tree.get(root))
            if (!seen.contains(i)) {
                res[i] = res[root] - count[i] + n - count[i];
                otherSumsBasedOnRoot(i, seen);
            }
        ;
    }
}
// 69 / 69 test cases passed.
// Runtime: 92 ms