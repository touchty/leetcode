package trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
677. Map Sum Pairs
Medium

270

52

Favorite

Share
Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 */
class MapSum {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        int value;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isWord = false;
            value = 0;
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
        }
        curr.isWord = true;
        curr.value = val;
    }

    public int sum(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                return 0;
            }
            curr = next;
        }

        return bfs(curr);
    }

    private int dfs(TrieNode root) {
        if (root == null)
            return 0;
        int sum = root.value;
        for (char c : root.children.keySet()) {
            sum += dfs(root.children.get(c));
        }
        return sum;
    }
    private int bfs(TrieNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            TrieNode node = queue.poll();
            sum += node.value;
            for (char c : node.children.keySet()) {
                queue.add(node.children.get(c));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        int sumAP = mapSum.sum("ap");
        System.out.println(sumAP);
        mapSum.insert("app", 2);
        int sumAPP = mapSum.sum("app");
        System.out.println(sumAPP);
    }
}
