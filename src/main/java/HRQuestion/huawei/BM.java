package HRQuestion.huawei;

import java.util.Arrays;

public class BM {
    static int indexOf(String text, String pattern) {
        if (pattern == null || pattern.length() == 0)
            return 0;

        int[] right = new int[256];
        Arrays.fill(right, -1);
        for (int i = 0; i < pattern.length(); i++) {
            right[pattern.charAt(i)] = i;
        }

        int m = pattern.length();
        int n = text.length();
        int skip = 0;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = Math.max(1, j - right[pattern.charAt(j)]);
                    break;
                }
                if (skip == 0)
                    return i; // find the pattern
            }
        }
        return n; // find no match
    }

    public static void main(String[] args) {
        String text = "abbcccbvbvbvbjfkgjksahdklabcdejkhnkjnjk";
        String pattern = "abcde";
        int index = indexOf(text, pattern);
        System.out.println(index);
        if (index < text.length())
            System.out.println(text.substring(index, index + pattern.length()));
    }
}
