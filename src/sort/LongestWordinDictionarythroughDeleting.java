package sort;

import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String str : d) {
            if (isSubsequence(s, str)) {
                if (str.length() > longest.length()) longest = str;
                else if (str.length() == longest.length() && str.compareTo(longest) < 0) longest = str;
            }
        }
        return longest;
    }

    private boolean isSubsequence(String str, String sub) {
        int index = 0;
        for (char c : sub.toCharArray()) {
            // searching from index, guarantee relative position
            index = str.indexOf(c,index);
            if (index == -1) return false;
            index++;
        }
        return true;
    }
}
