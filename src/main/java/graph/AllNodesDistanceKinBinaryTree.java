package graph;

import bfs.TreeNode;
import java.util.*;

/**
 * 863. All Nodes Distance K in Binary Tree
 * Medium
 *
 * 539
 *
 * 8
 *
 * Favorite
 *
 * Share
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 */

/*
PYTHON SOLUTION:
def distanceK(self, root, target, K):
        conn = collections.defaultdict(list)
        def connect(parent, child):
            if parent and child:
                conn[parent.val].append(child.val)
                conn[child.val].append(parent.val)
            if child.left: connect(child, child.left)
            if child.right: connect(child, child.right)
        connect(None, root)
        bfs = [target.val]
        seen = set(bfs)
        for i in range(K):
            bfs = [y for x in bfs for y in conn[x] if y not in seen]
            seen |= set(bfs)
        return bfs
 */
public class AllNodesDistanceKinBinaryTree {
    Map<Integer, List<Integer>> conn = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        connect(null, root);
        Set<Integer> seen = new HashSet<>();
        seen.add(target.val);
        List<Integer> bfs = new ArrayList<>();
        bfs.add(target.val);
        for (int i = 0; i < K; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int x : bfs) {
                for (int y : conn.get(x)) {
                    if (!seen.contains(y)) temp.add(y);
                }
            }
            bfs = temp;
            seen.addAll(bfs);
        }
        return bfs;
    }
    void connect(TreeNode parent, TreeNode child) {
        if (child == null) return;
        if (!conn.containsKey(child.val))
            conn.put(child.val, new ArrayList<>());
        if (parent != null) {
            if (!conn.containsKey(parent.val))
                conn.put(parent.val, new ArrayList<>());
            conn.get(parent.val).add(child.val);

            if (!conn.containsKey(child.val))
                conn.put(child.val, new ArrayList<>());
            conn.get(child.val).add(parent.val);
        }
        connect(child, child.left);
        connect(child, child.right);
    }
}
