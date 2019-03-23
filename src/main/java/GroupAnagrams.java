import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            String key = String.valueOf(cstr);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                List<String> list = map.get(key);
                list.add(str);
            }
        }

        ArrayList<List<String>> result = new ArrayList<>(map.values());
        return result;
    }

    public List<List<String>> groupAnagramsOpt(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, Integer> index = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char ch : s.toCharArray()) {
                key *= prime[ch - 'a'];
            }
            List<String> tmp;
            if (index.containsKey(key)) {
                tmp = ans.get(index.get(key));
                tmp.add(s);
            } else {
                tmp = new ArrayList<>();
                index.put(key, ans.size());
                tmp.add(s);
                ans.add(tmp);
            }
        }
        return ans;

    }
}
