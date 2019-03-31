package string;

import java.util.HashSet;
import java.util.Set;

/*
792. Number of Matching Subsequences
Medium

420

33

Favorite

Share
Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 */
public class NumberofMatchingSubsequences {
    public Set<String> numMatchingSubseq(String S, String[] words) {
        int sum = 0;
        HashSet<String> sub = new HashSet<>();
        HashSet<String> nonsub = new HashSet<>();
        for (String word : words) {
            if (sub.contains(word)) {
                sum++;
                continue;
            }
            if (nonsub.contains(word)) {
                continue;
            }
            if (isSub(S, word)) {
                sub.add(word);
                sum++;
            } else {
                nonsub.add(word);
            }
        }
        return sub;
    }

    private boolean isSub(String S, String word) {
        int index = -1;
        for (char ch : word.toCharArray()) {
            index = S.indexOf(ch, index + 1);
            if (index == -1)
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        String S = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        NumberofMatchingSubsequences solution = new NumberofMatchingSubsequences();
        Set<String> sub = solution.numMatchingSubseq(S, words);
        System.out.println(sub.size());
        System.out.println(sub);
    }
}
