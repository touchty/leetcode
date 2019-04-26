package string;

public class Calculator {
    public static void main(String[] args) {
        String S = "-10 + 12 + 13 + 5 - 20 + 10";
        int expected = 10;
        int i = Integer.parseInt("012");
//        System.out.println(i);
        int res = Calculator.eval(S);
        System.out.println(res);
    }

    static int eval(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int res = 0;
        int operator = 1; // +1 -1
        if (str.charAt(0) == '-') operator = -1;
        // prepare the string to be evaled as "0 +/-" + str
        StringBuilder builder = new StringBuilder("0");
        for (char c : str.toCharArray()) {
            if (c != '-' && c != '+' && c >= '0' && c <= '9') builder.append(c);
            else if (c == '-') {
                res += operator * Integer.parseInt(builder.toString());
                operator = -1;
                //builder = new StringBuilder();
                builder.setLength(0);
            } else if (c == '+') {
                res += operator * Integer.parseInt(builder.toString());
                operator = 1;
                //builder = new StringBuilder();
                builder.setLength(0);
            }
        }
        res += operator * Integer.parseInt(builder.toString());
        return res;
    }
}
