package test;

import java.util.*;

public class LC140WordBreakII {
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (map.containsKey(s))
            return map.get(s);
        int len = s.length();
        List<String> ret = new ArrayList<String>();
        // 不分割字符串
        if (wordDict.contains(s))
            ret.add(s);
        // 分割字符串， i是分割点
        for (int i = 1; i < len; i++) {
            String curr = s.substring(i);
            if (wordDict.contains(curr)) {
                List<String> strs = wordBreak(s.substring(0, i), wordDict);
                if (strs.size() != 0) {
                    /*for (Iterator<String> it = strs.iterator(); it.hasNext(); ) {
                        ret.add(it.next() + " " + curr);
                    }*/
                    for (String pre : strs) {
                        ret.add(pre + " " + curr);
                    }
                }
            }
        }
        map.put(s, ret);
        return ret;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> res = new LC140WordBreakII().wordBreak(s, Arrays.asList(wordDict));
        System.out.println(res);
    }
}
