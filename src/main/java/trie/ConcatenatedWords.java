package trie;

import java.util.*;

/*
472. Concatenated Words
Hard

209

50

Favorite

Share
Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 */
public class ConcatenatedWords {
    public class Solution {
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            TierNode root = new TierNode();

            for (int i = 0; i < words.length; i++) {
                buildTierTree(root, words[i]);
            }

            List<String> res = new ArrayList<>();

            for (int i = 0; i < words.length; i++) {
                if (isConcatenated(root, words[i], 0, 0)) {
                    res.add(words[i]);
                }
            }

            return res;
        }

        private void buildTierTree(TierNode root, String word) {
            TierNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TierNode();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }

        private boolean isConcatenated(TierNode root, String word, int start, int matched) {

            if (start == word.length()) {
                return matched > 1;
            }

            TierNode cur = root;

            for (int i = start; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (cur.children[index] == null) {
                    return false;
                }
                cur = cur.children[index];

                // find a word matches prefix, then recursively check remaining subfix
                if (cur.isWord && isConcatenated(root, word, i + 1, matched + 1)) {
                    return true;
                }
            }

            return false;
        }

        class TierNode {
            boolean isWord;
            TierNode[] children = new TierNode[26];
        }
    }

    public static class SolutionOpt {
        public static List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> result = new ArrayList<>();
            Set<String> preWords = new HashSet<>();
            Arrays.sort(words, Comparator.comparingInt(String::length));

            for (int i = 0; i < words.length; i++) {
                if (canForm(words[i], preWords)) {
                    result.add(words[i]);
                }
                preWords.add(words[i]);
            }

            return result;
        }

        private static boolean canForm(String word, Set<String> dict) {
            if (dict.isEmpty()) return false;
            // dp[i] means that word.substring(0, i+1) can be combined from dict
            boolean[] dp = new boolean[word.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= word.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (!dp[j]) continue;
                    // dp[j] == true
                    if (dict.contains(word.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[word.length()];
        }
    }

    public static void main(String[] args) {
        String[] words = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        SolutionOpt s = new SolutionOpt();
        List<String> list = s.findAllConcatenatedWordsInADict(words);
        System.out.println(list);
    }
}
