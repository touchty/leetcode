package HRQuestion.zhaoshangxyk;

import java.util.*;

public class Q2 {
    static long[] countsDirectedEdge(int[][] trees) {
        int n = trees.length + 1;
        int[] outs = new int[n + 1];
        long[] dp = new long[n + 1];
        for (int[] edge : trees) {
            outs[edge[0]]++;
        }

        Map<Integer, int[]> ps = new HashMap<>();
        for (int[] edge : trees) {
            ps.put(edge[1], new int[]{edge[0], edge[2]});
        }

        // b to u dp
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (outs[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (!ps.containsKey(curr))
                continue;
            int p = ps.get(curr)[0];
            outs[p]--;
            if (outs[p] == 0)
                queue.offer(p);
            dp[p] = Math.max(dp[p], Math.max(dp[curr] + ps.get(curr)[1], 0));
        }
        return dp;
    }

    static long[] countsUndirectedEdge(int[][] trees) {
        int n = trees.length + 1;
        int[] orders = new int[n + 1];
        long[] dp = new long[n + 1];
        boolean[] isDone = new boolean[n + 1];
        for (int[] edge : trees) {
            orders[edge[0]]++;
            orders[edge[1]]++;
        }

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] edge : trees) {
            List<int[]> list = adj.getOrDefault(edge[0], new LinkedList<>());
            list.add(new int[]{edge[1], edge[2]});
            adj.put(edge[0], list);
            list = adj.getOrDefault(edge[1], new LinkedList<>());
            list.add(new int[]{edge[0], edge[2]});
            adj.put(edge[1], list);
        }

        // b to u dp
        Queue<Integer> queue = new LinkedList<>();
        // leaf
        for (int i = 1; i <= n; i++) {
            if (orders[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            isDone[curr] = true;
            if (!adj.containsKey(curr))
                continue;
            for (int[] parentArr : adj.get(curr)) {
                int parent = parentArr[0];
                if (isDone[parent])
                    continue;

                // parent
                // curr ----weight---- parent
                int weight = parentArr[1];
                dp[parent] = Math.max(dp[parent], Math.max(dp[curr] + weight, 0));

                orders[parent]--;
                if (orders[parent] == 1) // has parent
                    queue.offer(parent);
            }

        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[][] trees = new int[n - 1][3];
            for (int i = 0; i < n - 1; i++) {
                trees[i][0] = scanner.nextInt();
                trees[i][1] = scanner.nextInt();
                trees[i][2] = scanner.nextInt();
            }
            long[] dp = countsUndirectedEdge(trees);
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                builder.append(dp[i]).append(" ");
            }
            System.out.println(builder.toString());
        }
    }
}
