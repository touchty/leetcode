package test;

import java.util.*;

// There are N network nodes, labelled 1 to N.
//
//Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
// v is the target node, and w is the time it takes for a signal to travel from source to target.
//
//Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is
// impossible, return -1.
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        // 邻接表
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq
        // 距离以及下一个节点的编号
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        // from node K to all other nodes
        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N + 1];
        int res = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();

            int curNode = cur[1];
            int curDist = cur[0];
            if (visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if (map.containsKey(curNode)) {
                for (int next : map.get(curNode).keySet()) {
                    //if (!visited[next])
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;
    }

    /**
     * dijkstra algorithm
     *
     * @param times u ----w----> v
     * @param N     number of nodes
     * @param K     source node
     * @return max path length to any nodes
     */
    public int networkDelayTimeRewrite(int[][] times, int N, int K) {
        // adj map, u: (v: distance)
        // 邻接表
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        //distance, node into pq
        // 距离以及下一个节点的编号
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // from node K to all other nodes
        pq.add(new int[]{0, K});

        boolean[] visited = new boolean[N + 1];
        int res = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();

            int currNode = curr[1];
            int currDist = curr[0];


            if (visited[currNode]) continue; // 不能在 res = currDist; 之后
            visited[currNode] = true;
            res = currDist; // 顺序不能错了
            N--;
            if (map.containsKey(currNode)) {
                for (int next : map.get(currNode).keySet()) {
                    //if (!visited[next])
                    pq.add(new int[]{currDist + map.get(currNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;
    }

    public static void main(String[] args) {
//        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int[][] times = {{2, 1, 1}, {1, 3, 1}, {3, 2, 1}};
        int N = 3, K = 2;
        NetworkDelayTime solution = new NetworkDelayTime();
        int path = solution.networkDelayTimeRewrite(times, N, K);
        System.out.println(path);
    }
}
