package array;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int mxLen = a.length() > b.length() ? a.length() : b.length();
        int[] res = new int[mxLen + 1];
        int aPtr = a.length() - 1;
        int bPtr = b.length() - 1;

        int i = mxLen;
        int sum = 0;
        int carry = 0;
        while (aPtr >= 0 && bPtr >= 0) {
            sum = (a.charAt(aPtr--) - '0' + b.charAt(bPtr--) - '0') + carry;
            res[i] = sum % 2;
            carry = sum / 2;
            i--;
        }

        while (aPtr >= 0) {
            sum = (a.charAt(aPtr--) - '0') + carry;
            res[i] = sum % 2;
            carry = sum / 2;
            i--;
        }

        while (bPtr >= 0) {
            sum = (b.charAt(bPtr--) - '0') + carry;
            res[i] = sum % 2;
            carry = sum / 2;
            i--;
        }

        res[0] = carry;

        StringBuilder builder = new StringBuilder();
        if (res[0] == 1)
            for (int e : res)
                builder.append(e);
        else
            for (int j = 1; j <= mxLen; j++)
                builder.append(res[j]);

        return builder.toString();
    }
}
