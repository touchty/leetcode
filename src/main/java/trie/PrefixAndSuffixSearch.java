package trie;

/*
745. Prefix and Suffix Search
Hard

173

137

Favorite

Share
Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:

Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
 */

/*
Solution:
Take "apple" as an example, we will insert add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple",
"{apple" into the Trie Tree.
If the query is: prefix = "app", suffix = "le", we can find it by querying our trie for
"le { app".
We use '{' because in ASCii Table, '{' is next to 'z', so we just need to create new TrieNode[27] instead of 26. Also,
compared with tradition Trie, we add the attribute weight in class TrieNode.
 */
public class PrefixAndSuffixSearch {
    static class TrieNode {
        TrieNode[] children;
        int weight;
        public TrieNode() {
            children = new TrieNode[27]; // 'a' - 'z' and '{'. 'z' and '{' are neighbours in ASCII table
            weight = 0;
        }
    }

    public static class WordFilter {
        TrieNode root;
        public WordFilter(String[] words) {
            root = new TrieNode();
            for (int weight = 0; weight < words.length; weight++) {
                String word = words[weight] + "{";
                for (int i = 0; i < word.length(); i++) {
                    TrieNode cur = root;
                    cur.weight = weight;
                    // add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree
                    for (int j = i; j < 2 * word.length() - 1; j++) {
                        int k = word.charAt(j % word.length()) - 'a';
                        if (cur.children[k] == null)
                            cur.children[k] = new TrieNode();
                        cur = cur.children[k];
                        cur.weight = weight; // update larger weight
                    }
                }
            }
        }
        public int f(String prefix, String suffix) {
            TrieNode cur = root;
            for (char c: (suffix + '{' + prefix).toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return -1;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.weight;
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple"};
        PrefixAndSuffixSearch search = new PrefixAndSuffixSearch();
        WordFilter filter = new PrefixAndSuffixSearch.WordFilter(words);
        int weight = filter.f("apple", "ple");
        System.out.println(weight);
    }
}
