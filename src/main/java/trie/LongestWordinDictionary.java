package trie;

import org.junit.Assert;

/*
720. Longest Word in Dictionary
Easy

312

386

Favorite

Share
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
 */
public class LongestWordinDictionary {
    /*class TrieNode {
        String word = "";
        TrieNode[] children = new TrieNode[26];
    }

    TrieNode root = new TrieNode();

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";

        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.word = word;
        }

        return dfs(root);
    }

    public String dfs(TrieNode node) {
        String res = node.word;
        for (TrieNode child : node.children) {
            if (child != null && child.word.length() != 0) {
                String childWord = dfs(child);
                if (childWord.length() > res.length() ||
                        (childWord.length() == res.length() && childWord.compareTo(res) < 0))
                    res = childWord;
            }
        }
        return res;
    }*/

    class TrieNode {
        // String word;
        // TrieNode[] children;
        // public TrieNode() {
        //     word = "";
        //     children = new TrieNode[26];
        // }
        String word = "";
        TrieNode[] children = new TrieNode[26];
    }


    public String longestWord(String[] words) {
        // build trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root; // the position should be in the loop
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return dfs(root);
    }

    String dfs(TrieNode root) {
        String res = root.word;
        for (TrieNode child : root.children) {
            if (child != null && child.word.length() > 0) {
                String potential = dfs(child);
                if (potential.length() > res.length() ||
                        (potential.length() == res.length() && potential.compareTo(res) < 0))
                    res = potential;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        LongestWordinDictionary solution = new LongestWordinDictionary();
        String longestStr = solution.longestWord(words);
        String expected = "apple";
        Assert.assertEquals(expected, longestStr);
        System.out.println(longestStr);
    }
}
