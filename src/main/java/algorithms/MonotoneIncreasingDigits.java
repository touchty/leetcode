package algorithms;

/*
738. Monotone Increasing Digits
Medium

223

36

Favorite

Share
Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
 */
public class MonotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int N) {
        String numStr = "" + N;
        char[] numChar = numStr.toCharArray();
        int maker = numChar.length;
        for (int i = numChar.length - 1; i >= 1; i--) {
            if (numChar[i] < numChar[i - 1]) {
                maker = i;
                numChar[i - 1] -= 1;
            }
        }

        for (int i = maker; i < numChar.length; i++) {
            numChar[i] = '9';
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numChar.length; i++) {
            builder.append(numChar[i]);
        }
        String res = builder.toString();
        return Integer.parseInt(res);
    }

    public static void main(String[] args) {
        int N = 1234;
        int res = MonotoneIncreasingDigits.monotoneIncreasingDigits(N);
        System.out.println(res);
    }
}
