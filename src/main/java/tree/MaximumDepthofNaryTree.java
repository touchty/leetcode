package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
559. Maximum Depth of N-ary Tree
Easy

274

18

Favorite

Share
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:
             1
       2     3      4
     5   6
 */
public class MaximumDepthofNaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        // bfs to count the total levels
        if (root == null)
            return 0;
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node temp : node.children) {
                    queue.add(temp);
                }
            }
        }
        return level;
    }
}
