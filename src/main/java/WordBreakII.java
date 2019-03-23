import java.util.*;

public class WordBreakII {
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        /*if(map.containsKey(s))  //take from memory
            return map.get(s);*/

        int len = s.length();
        List<String> ret = new ArrayList<>();
        if (wordDict.contains(s))
            ret.add(s);
        for (int i = 1; i < len; i++) {
            String curr = s.substring(i); // i ==== tail
            if (wordDict.contains(curr)) {
                List<String> strs = wordBreak(s.substring(0, i), wordDict);
                if (strs.size() != 0) {
                    for (Iterator<String> it = strs.iterator(); it.hasNext(); ) {
                        ret.add(it.next() + " " + curr);
                        System.out.println("curr : " + curr);
                        System.out.println("ret : " + ret);

                    }
                }
            }
        }
        map.put(s, ret);
        System.out.println("take from memory " + s);
        return ret;
    }

    Map<String, List<String>> mapRe = new HashMap<String, List<String>>();

    public List<String> wordBreakRe(String s, List<String> wordDict) {

        if (mapRe.containsKey(s)) // get from memory
            return mapRe.get(s);

        List<String> ret = new ArrayList<String>();
        if (wordDict.contains(s))  // a whole string is in  dict
            ret.add(s);

        for (int i = 1; i < s.length(); i++) {
            String curr = s.substring(i);
            if (wordDict.contains(curr)) {
                // strs is a List
                List<String> strs = wordBreakRe(s.substring(0, i), wordDict);
                if (strs.size() > 0) {
                    for (String str : strs) {
                        ret.add(str + " " + curr);
                    }
                }
            }
        }

        mapRe.put(s, ret);  // memorize in order to optimize performance!
        return ret;
    }


    public static void main(String[] args) {
        String s = "catsanddog";
        String[] dict = {"cat", "cats", "and", "sand", "dog"};
        List<String> wordDict = new ArrayList<String>();
        for (String str : dict) {
            wordDict.add(str);
        }

        WordBreakII wb = new WordBreakII();

        List<String> result = wb.wordBreakRe(s, wordDict);
        List<String> resultRe = wb.wordBreakRe(s, wordDict);

        for (String str : result
                ) {
            System.out.println(str);
        }
    }
}


