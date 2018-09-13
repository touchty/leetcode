package string;

import java.util.*;

/**
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 * Note:
 *
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 */
public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> list = new ArrayList<>();

        for (String word : words) {
            if (word.length() != pattern.length()) continue;

            int[] map = new int[26];
            boolean[] mapped = new boolean[26];

            Arrays.fill(map, 0, map.length, -1);

            for (int i = 0; i < word.length(); i++) {
                if (map[pattern.charAt(i) - 'a'] == -1 && !mapped[word.charAt(i) - 'a']) {
                    // check word.charAt(i) is not mapped!!!
                    map[pattern.charAt(i) - 'a'] = word.charAt(i) - 'a';
                    mapped[word.charAt(i) - 'a'] = true;
                }

                if (map[pattern.charAt(i) - 'a'] != word.charAt(i) - 'a') break;
                if (i == word.length() - 1) list.add(word);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        FindAndReplacePattern find = new FindAndReplacePattern();
        //String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> list = find.findAndReplacePattern(words, pattern);
        System.out.println(list.size());
    }
}
