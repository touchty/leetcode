package HRQuestion.cisico;

import java.util.Scanner;

public class Name {
    /*static String name(String s) {
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
    }*/
    static String name(String s) {
        int pos = s.indexOf("<");
        if (pos <= 1) {
            return "";
        }
        String mySplit = "%22";
        String nameStr = s.substring(0, pos);
        if (nameStr.indexOf(mySplit) == 1) {
            if (nameStr.charAt(nameStr.length() - 1) == '"') {
                if (nameStr.lastIndexOf(mySplit) != nameStr.length() - 4)
                    return nameStr.substring(1, nameStr.length() - 1);
                return nameStr.substring(4, nameStr.length() - 4);
            } else {
                if (nameStr.lastIndexOf(mySplit) != nameStr.length() - 3)
                    return nameStr.substring(1);
                return nameStr.substring(4, nameStr.length() - 3);
            }
        } else {
            if (nameStr.charAt(nameStr.length() - 1) == '"')
                return nameStr.substring(1, nameStr.length() - 1);
            else
                return nameStr.substring(1);
        }
    }

    static String nameTY(String s) {
        // "<sip......>"
        int index = s.indexOf("<");
        if (index <= 1) {
            return "";
        }

        String prefix = s.substring(0, index);
        if (prefix.indexOf("%22") != 1) {
            if (prefix.charAt(prefix.length() - 1) == '"')
                return prefix.substring(1, prefix.length() - 1);
            else
                return prefix.substring(1);
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
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(name(s));
    }
}
