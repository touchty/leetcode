import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstr {
    public int lengthOfLongestSubstring(String s) {
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

    // i ....... j
    public int lengthOfLongestSubstringSet(String s){
        if (s.length() == 0) return 0;
        int ans = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while (i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else
                set.remove(s.charAt(i++));
        }

        return ans;
    }

    public int lengthOfLongestSubstringAscii(String s){
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }


        public static void main(String[] args) {
        LongestSubstr l = new LongestSubstr();
        int max = l.lengthOfLongestSubstringAscii("pwwkew");
        System.out.println(max);
        assert false;
    }
}
