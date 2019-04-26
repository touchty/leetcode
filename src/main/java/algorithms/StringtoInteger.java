package algorithms;

public class StringtoInteger {
    public int myAtoi(String str) {

        str = str.trim();
        if (str.isEmpty())
            return 0;
        int i = 0, ans = 0, sign = 1, len = str.length();
        while (i < str.length()) {
            if (str.charAt(i) == '-' || str.charAt(i) == '+')
                sign *= str.charAt(i++) == '+' ? 1 : -1;
            else
                break;
        }

        for (; i < len; ++i) {
            int tmp = str.charAt(i) - '0';
            if (tmp < 0 || tmp > 9)
                break;
            /*
            Java int:int is 32 bit signed type ranges from –2,147,483,648 to 2,147,483,647.
             */
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                ans = ans * 10 + tmp;
        }
        return sign * ans;
    }

    public static void main(String[] args) {
        String s = "+-+-123 a";
        StringtoInteger solution = new StringtoInteger();
        int res = solution.myAtoi(s);
        System.out.println(res);
    }
}
