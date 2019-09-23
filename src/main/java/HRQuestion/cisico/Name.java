package HRQuestion.cisico;

import java.util.Scanner;

public class Name {
    static String name(String s) {
        // "<sip......>"
        int index = s.indexOf("<");
        if (index <= 1) {
            return "";
        }

        String prefix = s.substring(0, index);
        if (prefix.length() <= 2)
            return "";
        if (prefix.indexOf("%22") != 1) {
            return prefix.substring(1, prefix.length() - 1);
        } else {
            if (prefix.charAt(prefix.length() - 1) == '"') {
                if (prefix.lastIndexOf("%22") != prefix.length() - 4)
                    return prefix.substring(1, prefix.length() - 1);
                return prefix.substring(4, prefix.length() - 4);
            } else {
                if (prefix.lastIndexOf("%22") != prefix.length() - 3)
                    return prefix.substring(1);
                return prefix.substring(4, prefix.length() - 3);
            }
        }
    }

    public static void main(String[] args) {
        //String s = "\"%22Cisico%22\"<sip:123>";
        //System.out.println(name(s));
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(name(s));
    }
}
