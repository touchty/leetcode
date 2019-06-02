package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// LZW 压缩算法
// 参考
// https://blog.csdn.net/qq_41819698/article/details/82558107

public class LZW {

    public List<Integer> encode(String data) {
        List<Integer> result = new ArrayList<Integer>();

        // 初始化Dictionary
        int idleCode = 256;
        HashMap<String, Integer> dic = new HashMap<String, Integer>();
        for (int i = 0; i < 256; i++) {
            dic.put((char) i + "", i);
        }

        String prefix = "";// 词组前缀
        String suffix = "";// 词组后缀
        for (char c : data.toCharArray()) {
            suffix = prefix + c;
            if (dic.containsKey(suffix)) {
                prefix = suffix;
            } else {
                System.out.println(suffix + idleCode);
                dic.put(suffix, idleCode++);
                System.out.println(suffix);
                result.add(dic.get(prefix));
                // System.out.println(dic.get(prefix));
                prefix = "" + c;
            }
        }

        // 最后一次输出
        if (!prefix.equals("")) {
            result.add(dic.get(prefix));
            // System.out.println(dic.get(prefix));
        }
        return result;
    }

    public String decode(List<Integer> array) {

        StringBuilder result = new StringBuilder();
        int deCode = 256;
        HashMap<Integer, String> dic = new HashMap<Integer, String>();
        for (int i = 0; i < 256; i++) {
            dic.put(i, (char) i + "");
        }
        String p = "";
        String c = "";
        for (int code : array) {

            if (dic.containsKey(code)) {
                c = dic.get(code);
            } else if (code == deCode) {
                c = c + c.charAt(0);
                System.out.println("code == deCode");
            } else {
                System.out.println("bad Code!");
            }

            if (!p.equals("")) {
                dic.put(deCode++, p + c.charAt(0));
            }

            result.append(c);
            // this.write("lzw解压.txt", c);
            p = c;
        }
        System.out.println("++++");
//		System.out.println(result);
        return result.toString();
    }


    public static void main(String[] args) {
        String text = "abab";
        LZW solution = new LZW();
        List<Integer> list = solution.encode(text);
        System.out.println(list);
        String decoded = solution.decode(list);
        System.out.println(decoded );
    }
}
