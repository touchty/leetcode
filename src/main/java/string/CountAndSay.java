package string;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String str = "1";

        for (int i = 2; i <= n; i++) {
            str = helper(str);
        }
        return str;
    }

    String helper(String str) {
        char c = str.charAt(0);
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i))
                count++;
            else {
                builder.append(count);
                builder.append(c);
                count = 1;
                c = str.charAt(i);
            }
        }

        builder.append(count);
        builder.append(c);
        return builder.toString();
    }
}
