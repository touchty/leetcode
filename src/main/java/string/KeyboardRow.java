package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 500. Keyboard Row
 * Easy
 * 351
 * 426
 * Favorite
 * Share
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
 * keyboard like the image below.
 * Example:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        for (char c : line1.toCharArray())
            set1.add(c);
        for (char c : line2.toCharArray())
            set2.add(c);
        for (char c : line3.toCharArray())
            set3.add(c);

        List<String> list = new ArrayList<>();

        for (String str : words) {
            List<Character> newSet = new ArrayList<>();
            for (char c : str.toCharArray()) {
                newSet.add(Character.toLowerCase(c));
            }
            if (set1.containsAll(newSet) || set2.containsAll(newSet) || set3.containsAll(newSet))
                list.add(str);
        }

        String[] res = new String[list.size()];
        res = list.toArray(res);
        return res;
    }
}
