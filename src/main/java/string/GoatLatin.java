package string;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>(10);
        for (char c : "aeiouAEIOU".toCharArray()) vowel.add(c);
        StringBuilder res = new StringBuilder();
        StringBuilder tail = new StringBuilder("maa");
        for (String w : S.split("\\s")) {
            res.append(' ');
            if (vowel.contains(w.charAt(0)))
                res.append(w);
            else
                res.append( w.substring(1)).append(w.charAt(0));
            res.append(tail);
            tail.append('a');
        }
        return res.substring(1);
    }
}
