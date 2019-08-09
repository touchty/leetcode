package offer;

public class O20isNumeric {
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        char[] num = "-1E-16".toCharArray();
        System.out.println(O20isNumeric.isNumeric(num));
    }
}
