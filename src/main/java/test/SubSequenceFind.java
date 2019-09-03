package test;

import java.util.HashMap;
import java.util.Map;

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
                if (right - left == m - 1)
                    return left;
            }
        }
        return -1;
    }
}
