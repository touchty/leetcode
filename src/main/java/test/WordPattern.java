package test;

import java.util.HashMap;
import java.util.Map;

// 290. Word Pattern
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String p = "ab";
        String m = "aa bb";
        boolean matched = WordPattern.wordPattern(p, m);
        System.out.println(matched);
    }
}
