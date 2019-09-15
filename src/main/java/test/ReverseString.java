package test;

public class ReverseString {
    char[] reverse(char[] chars) {
        if (chars == null || chars.length <= 1)
            return chars;

        for (int i = 0; i < chars.length / 2; i++) {
            char t = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = t;
        }
        return chars;
    }
}
