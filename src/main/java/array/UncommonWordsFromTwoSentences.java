package array;

import java.util.*;

/**
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 *
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 *
 * Return a list of all uncommon words.
 *
 * You may return the list in any order.
 * Example 1:
 *
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 *
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 */
public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        String[] As = A.split(" ");
        String[] Bs = B.split(" ");
        ArrayList<String> list = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String str : As) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : Bs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }

        String[] res = new String[list.size()];
        res = list.toArray(res);

        return res;
    }
}
