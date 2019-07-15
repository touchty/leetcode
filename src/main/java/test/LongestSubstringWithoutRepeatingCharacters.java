package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Set 记录出现的字符
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(26);
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (j < i) {
                    set.remove(s.charAt(j));
                    if (s.charAt(i) == s.charAt(j)) {
                        j++;
                        break;
                    }
                    j++;
                }
                set.add(s.charAt(i)); // 删除后再次添加
            } else {
                set.add(s.charAt(i));
                max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }

    public int lengthOfLongestSubstringOpt(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int max = LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
        System.out.println(max);
    }
}
