package trie;

import org.junit.Assert;

import java.util.*;

/*
820. Short Encoding of Words
Medium

139

38

Favorite

Share
Given a list of words, we may encode it by writing a reference string S and a list of indexes A.

For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].

Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.

What is the length of the shortest reference string S possible that encodes the given words?

Example:

Input: words = ["time", "me", "bell"]
Output: 10
Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 */
public class ShortEncodingofWords {
    class TrieNode {
        HashMap<Character, TrieNode> next = new HashMap<>();
        int depth;
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new ArrayList<>();
        for (String w : new HashSet<>(Arrays.asList(words))) {
            TrieNode cur = root;
            for (int i = w.length() - 1; i >= 0; --i) {
                char j = w.charAt(i);
                if (!cur.next.containsKey(j)) cur.next.put(j, new TrieNode());
                cur = cur.next.get(j);
            }
            cur.depth = w.length() + 1;
            leaves.add(cur);
        }
        int res = 0;
        for (TrieNode leaf : leaves) if (leaf.next.isEmpty()) res += leaf.depth;
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        ShortEncodingofWords solution = new ShortEncodingofWords();
        int result = solution.minimumLengthEncoding(words);
        int expected = 10;
        Assert.assertEquals(expected, result);
    }
}
