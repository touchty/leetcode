package HRQuestion.tx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//有字符串ab=1&cd=234&e=xy&e=cd，实现代码对字符串分割，
// 输出 ab=>1    cd=234  e=xy，需要考虑异常场景，不使用语言内置库函数
public class Main2 {
    //ab=1&cd=234&e=xy
    //ab:1
    //cd:234
    //e:xy
    static Map<String, String> parse(String s) {
        List<String> strings = split(s, '&');

        Map<String, String> map = new HashMap<>();

        for (String str : strings) {
            List<String> tempStrs = split(str, '=');
            if (tempStrs.size() == 1 && str.charAt(0) != '=') {
                map.put(tempStrs.get(0), null);
            }
            if (tempStrs.size() == 2) {
                map.put(tempStrs.get(0), tempStrs.get(1));
            }
        }
        return map;
    }

    static private List<String> split(String s, char c) {
        StringBuilder builder = new StringBuilder();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                if (builder.length() == 0)
                    continue;
                strings.add(builder.toString());
                builder = new StringBuilder();
            } else {
                builder.append(s.charAt(i));
            }
        }
        if (builder.length() > 0)
            strings.add(builder.toString());
        return strings;
    }

    public static void main(String[] args) {
//       String s = "ab=1&cd=234&e=xy&e=cd";
        //String s = "ab=1&cd=";
        String s = "ab=1&cd=234&&e=xy";
        Map<String, String> map = parse(s);
        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println(e.getKey() + "=>" + e.getValue());
        }
    }
}
