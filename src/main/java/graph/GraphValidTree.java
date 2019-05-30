package graph;

import java.util.*;
//  无向图成环问题
// LC 261
public class GraphValidTree {
    private HashSet<Integer> visited;
    private int n;
    private int[][] graph;

    private boolean dfs(int node) {
        for (int dest = 0; dest < n; dest++) {
            if (graph[node][dest] == 0) continue;
            if (visited.contains(dest)) return false;
            visited.add(dest);
            graph[node][dest] = 0;
            graph[dest][node] = 0;
            if (!dfs(dest)) return false;
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {

        if (n == 0 || n == 1) return true;
        if (edges == null || edges.length == 0) return false;
        this.n = n;
        graph = new int[n][n];
        visited = new HashSet<>();
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        visited.add(edges[0][0]);
        int root = edges[0][0];
        return dfs(root) && visited.size() == n;
    }

    public boolean validTreeMap(int n, int[][] edges) {
        if (n <= 1) return true;

        if (edges == null || edges.length == 0)
            return false;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            Set<Integer> set = map.getOrDefault(edge[0], new HashSet<>());
            set.add(edge[1]);
            map.put(edge[0], set);

            Set<Integer> set1 = map.getOrDefault(edge[1], new HashSet<>());
            set1.add(edge[0]);
            map.put(edge[1], set1);
        }

        HashSet<Integer> visited = new HashSet<>();
        int root = edges[0][0];
        visited.add(root);
        dfsMap(map, root, visited);
        int N = 0;
        for (Set<Integer> set : map.values())
            N += set.size();

        N /= 2;
        return N == n- 1 && visited.size() == n;
    }

    void dfsMap(Map<Integer, Set<Integer>> map, int root, Set<Integer> visited) {
        for (int next : map.get(root)) {
            if (visited.contains(next))
               continue;
            visited.add(next);
            dfsMap(map, next, visited);
        }
    }

    class Solution {
        public boolean validTree(int n, int[][] edges) {
            if (n==0||n==1) return true;
            if (edges==null||edges.length==0) return false;
            List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[n];
            for (int[] edge:edges){
                if (graph[edge[0]]==null) graph[edge[0]] = new ArrayList<>();
                if (graph[edge[1]]==null) graph[edge[1]] = new ArrayList<>();
                graph[edge[0]].add(edge[1]);
                graph[edge[1]].add(edge[0]);
            }
            int root = edges[0][0];
            List<Integer> queue = new ArrayList<>();
            HashSet<Integer> visited = new HashSet<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int number = queue.size();
                for (int i=0;i<number;i++){
                    int node = queue.remove(0);
                    if (visited.contains(node)) return false;
                    visited.add(node);
                    queue.addAll(graph[node]);
                    for (int dest:graph[node]){
                        graph[dest].remove((Integer)node); // remove the bidirection
                    }
                }
            }
            return visited.size()==n;
        }
    }
    public static void main(String[] args) {
        int[][] es = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        GraphValidTree solution = new GraphValidTree();
        boolean res = solution.validTreeMap(n, es);
        System.out.println(res);
    }
}
