package HRQuestion.huawei;

import java.util.Scanner;

public class Q1 {
    static String clean(String s, String t) {
        int index = s.indexOf(t);
        if (index < 0)
            return s;
        StringBuilder builder = new StringBuilder(s);
        for (int i = index; i < index + t.length(); i++) {
            builder.setCharAt(i, '*');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        /*String s = "abcABC";
        String t = "ABC";
        System.out.println(clean(s, t));*/
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t =  scanner.next();
        System.out.println(clean(s, t));
    }
}
