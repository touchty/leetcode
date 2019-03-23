package graph;

import java.util.*;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        return dfsSearch(graph, 0, map);
    }

    private List<List<Integer>> dfsSearch(int[][] graph, int node, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        List<List<Integer>> res = new ArrayList<>();
        if (node == graph.length - 1) {
            List<Integer> path = new LinkedList<>();
            path.add(node);
            res.add(path);
        } else {
            for (int nextNode : graph[node]) {
                List<List<Integer>> subPaths = dfsSearch(graph, nextNode, map);
                for (List<Integer> path : subPaths) {
                    LinkedList<Integer> newPath = new LinkedList<>(path);
                    newPath.addFirst(node);
                    res.add(newPath);
                }
            }
        }

        map.put(node, res);
        return res;
    }

    // Opt
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> path = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            list.add(0);
            path_utils(path, list, graph, 0, graph.length - 1);

            return path;
        }

        public void path_utils(List<List<Integer>> path_list, List<Integer> path, int[][] graph, int s, int e) {
            if (s == e) {
                path_list.add(new ArrayList<Integer>(path));
                return;
            }

            for (int i : graph[s]) {
                path.add(i);
                path_utils(path_list, path, graph, i, e);
                path.remove(path.size() - 1);
            }

        }

    }
}
