package trie;

import java.util.*;

/*
        root (f)
           | 'a'
          n1 (t)
     ------------
 'b' |          | 'a'
    n2 (t)    n3 (f)
                | 'a'
              n4 (t)
1. For word "ba", starting from the first character 'b', index into the root.next array with index given by 'b' - 'a' = 1.
The corresponding node is null, then we know there are no words ending at this character, so the searching process is
terminated;

2. For word "a", again indexing into array root.next at index given by 'a' - 'a' = 0 will yield node n1, which is not null. We then check the value of n1.isWord. If it is true, then it is possible to obtain a palindrome by appending this word to the one currently being examined (a.k.a word "a"). Also note that the two words should be distinct from each other, but the n1.isWord field provides no information about the word itself, which makes it impossible to distinguish the two words. So it is necessary to modify the structure of the TrieNode so that we can identify the word it represents. One easy way is to have an integer field to remember the index of the word in the words array. For non-word nodes, this integer will take negative values (-1 for example) while for those representing a word, it will be non-negative values. Suppose we have made this modification, then the two words will be identified to be the same, so we discard this pair combination. Since the word "a" has only one letter, it seems we are done with it. Or do we? Not really. What if there are words with suffix "a" ("aaa" in this case)? We need to continue to check the rest part of these words (such as "aa" for the word "aaa") and see if the rest forms a palindrome. If it is, then appending this word ("aaa" in this case) to the original word ("a") will also form a palindrome ("aaaa"). Here I take another strategy: add an integer list to each TrieNode; the list will record the indices of all words satisfying the following two conditions: 1. each word has a suffix represented by the current TrieNode; 2. the rest of the word forms a palindrome.

          root (-1,[1,2])
            | 'a'
          n1 (1,[0,1,2])
    ---------------------
'b' |                 | 'a'
  n2 (0,[0])    n3 (-1,[2])
                      | 'a'
                 n4 (2,[2])
Here I take another strategy: add an integer list to each TrieNode; the list will record the indices of all words
satisfying the following two conditions: 1. each word has a suffix represented by the current TrieNode; 2. the rest of
the word forms a palindrome.
*/
public class PalindromePairs {
    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }

        return res;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';

            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }

            // 1. each word has a suffix represented by the current TrieNode; 2. the rest of
            // the word forms a palindrome.
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) return;
        }

        for (int j : root.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abb", "bba"};
        List<List<Integer>> pairs;
        //pairs = new PalindromePairs().palindromePairs(words);
//        for (List<Integer> pair : pairs) {
//            //System.out.println(pair);
//        }

        words = new String[]{"abc", "defcba"};
        pairs = new PalindromePairs().palindromePairs(words);
        Collections.sort(pairs, Comparator.comparingInt(a -> a.get(0)));
        for (List<Integer> pair : pairs) {
            System.out.println(pair);
        }
    }
}
