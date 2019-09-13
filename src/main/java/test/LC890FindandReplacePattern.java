package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
890. Find and Replace Pattern
Medium

434

44

Favorite

Share
You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern.

You may return the answer in any order.
 */
public class LC890FindandReplacePattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int encoder = 0;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), encoder);
                builder.append(encoder);
                encoder++;
            } else {
                builder.append(map.get(pattern.charAt(i)));
            }
        }
        pattern = builder.toString();

        for (String s : words) {
            Map<Character, Integer> sMap = new HashMap<>();
            StringBuilder sBuilder = new StringBuilder();
            int sEncoder = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!sMap.containsKey(s.charAt(i))) {
                    sMap.put(s.charAt(i), sEncoder);
                    sBuilder.append(sEncoder);
                    sEncoder++;
                } else {
                    sBuilder.append(sMap.get(s.charAt(i)));
                }
            }
            String sEncoded = sBuilder.toString();
            if (sEncoded.equals(pattern)) {
                list.add(s);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> list = findAndReplacePattern(strings, pattern);
        System.out.println(list);
    }
}
