package test;

import java.util.HashMap;
import java.util.Map;

/*
基础：给定m个不重复的字符 [a, b, c, d]，以及一个长度为n的字符串tbcacbdata，
问能否在这个字符串中找到一个长度为m的连续子串，使得这个子串刚好由上面m个字符组成，
顺序无所谓，返回任意满足条件的一个子串的起始位置，未找到返回-1。比如上面这个例子，acbd，3。
 */
public class SubSequenceFind {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    int sub(String str, char[] target) {
        // ^ m
        if (str == null || str.length() == 0)
            return -1;

        int left = 0;
        int right = 0;
        int m = target.length;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], -1);
        }
        int[] count = new int[m];
        while (right < target.length) {
            while (left < target.length && !map.containsKey(str.charAt(left))) {
                left++;
            }
            right = left;
            // slide
            while (right < target.length) {
                //合法
                if (map.containsKey(str.charAt(right)) && map.get(str.charAt(right)) < left) {
                    map.put(str.charAt(right), right);
                    right++;
                }
                //重复
                else if (map.containsKey(str.charAt(right)) && map.get(str.charAt(right)) >= left) {
                    left = map.get(str.charAt(right)) + 1;
                    map.put(str.charAt(right), right);
                    right++;
                }
                //不合法
                else {
                    left = right + 1;
                    right++;
                }
                if (right < target.length && right - left == m - 1)
                    return left;
            }
        }
        return -1;
    }
}
