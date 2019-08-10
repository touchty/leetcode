package offer;

public class O20isNumeric {
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        // "-.123" 是合法的
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        char[] num = ".1".toCharArray();
        System.out.println(O20isNumeric.isNumeric(num));
    }
}
