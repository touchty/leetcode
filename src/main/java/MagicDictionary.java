import org.junit.Assert;

import java.util.*;

/*
676. Implement Magic Dictionary
Medium

332

93

Favorite

Share
Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class MagicDictionary {

    Map<String, List<int[]>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[]{i, s.charAt(i)};

                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);

                map.put(key, val);
            }
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] pair : map.get(key)) {
                    if (pair[0] == i && pair[1] != word.charAt(i)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] dicts = {"hello", "leetcode"};
        String[] strToSearch = {"hello", "hhllo", "leetcoed", "leetcodq"};
        boolean[] searchRes = new boolean[strToSearch.length];
        MagicDictionary dictionary = new MagicDictionary();
        dictionary.buildDict(dicts);
        for (int i = 0; i < strToSearch.length; i++) {
            searchRes[i] = dictionary.search(strToSearch[i]);
        }

        boolean[] expected = {false, true, false, true};
        Assert.assertArrayEquals(expected, searchRes);
    }
}

class MagicDictionaryTrie {

    TrieNode mFakeRoot;
    int mOffset = 'a';

    /**
     * Initialize your data structure here.
     */
    public MagicDictionaryTrie() {
        mFakeRoot = new TrieNode();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode cur = mFakeRoot;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.mChildren[c - mOffset] == null) {
                    cur.mChildren[c - mOffset] = new TrieNode();
                }
                cur = cur.mChildren[c - mOffset];
            }
            cur.mIsWord = true;
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        return search(word, 0, mFakeRoot, false);
    }

    private boolean search(String word, int index, TrieNode cur, boolean modified) {
        if (index == word.length()) {
            return cur.mIsWord && modified;
        }
        int c = word.charAt(index);

        // modified == false, the word was never modified before
        if (modified == false) {
            for (int i = 0; i < cur.mChildren.length; i++) {
                // modify the char at index
                if (cur.mChildren[i] != null && (i + mOffset) != c) {
                    if (search(word, index + 1, cur.mChildren[i], true)) {
                        return true;
                    }
                }
            }
            // don't modify the char at index
            return cur.mChildren[c - mOffset] != null &&
                    search(word, index + 1, cur.mChildren[c - mOffset], false);
        }

        // modified == true, i.e. some character was modified already
        return cur.mChildren[c - mOffset] != null &&
                search(word, index + 1, cur.mChildren[c - mOffset], true);
    }

    private class TrieNode {
        TrieNode[] mChildren;
        boolean mIsWord;

        public TrieNode() {
            mChildren = new TrieNode[26];
            mIsWord = false;
        }
    }

    public static void main(String[] args) {
        String[] dicts = {"hello", "leetcode"};
        String[] strToSearch = {"hello", "hhllo", "leetcoed", "leetcodq"};
        boolean[] searchRes = new boolean[strToSearch.length];
        MagicDictionaryTrie dictionaryTrie = new MagicDictionaryTrie();
        dictionaryTrie.buildDict(dicts);
        for (int i = 0; i < strToSearch.length; i++) {
            searchRes[i] = dictionaryTrie.search(strToSearch[i]);
        }

        boolean[] expected = {false, true, false, true};
        Assert.assertArrayEquals(expected, searchRes);
    }
}