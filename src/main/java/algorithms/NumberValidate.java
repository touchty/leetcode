package algorithms;

public class NumberValidate {
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        // true
        String[] s1 = {"+100", "5e2", "-123", "3.1416", "-1E-16"};
        //false
        String[] s2 = {
                "12e",
                "1a3.14",
                "1.2.3",
                "+-5",
                "12e+4.3"};

    }
}
