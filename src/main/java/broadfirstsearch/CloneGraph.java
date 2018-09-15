package broadfirstsearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<Integer, UndirectedGraphNode> created = new HashMap();
        dfs(node, created);
        return created.get(node.label);
    }
    private void dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> created) {
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        created.put(copy.label, copy);
        for (UndirectedGraphNode next : node.neighbors) {
            if (!created.containsKey(next.label)) {
                dfs(next, created);
            }
            UndirectedGraphNode nextCopy = created.get(next.label);
            copy.neighbors.add(nextCopy);
        }
    }

    // Definition for undirected graph.
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
