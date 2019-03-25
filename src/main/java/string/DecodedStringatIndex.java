package string;

/*
880. Decoded String at Index
Medium

205

46

Favorite

Share
An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.



Example 1:

Input: S = "leet2code3", K = 10
Output: "o"
Explanation:
The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".
Example 2:

Input: S = "ha22", K = 5
Output: "h"
Explanation:
The decoded string is "hahahaha".  The 5th letter is "h".
 */
public class DecodedStringatIndex {
    public static String decodeAtIndex(String S, int K) {
        long N = 0;
        int i = 0;
        for (i = 0; N < K && i < S.length(); i++) {
            N = Character.isDigit(S.charAt(i)) ? N * (S.charAt(i) - '0') : N + 1;
        }

        while (i-- > 0) {
            if (Character.isDigit(S.charAt(i))) {
                N /= (S.charAt(i) - '0');
                K %= N;
            } else if (K == N || K == 0) {
                return String.valueOf(S.charAt(i));
            }
        }

        return "";
    }

    public static void main(String[] args) {
            /*
    a23 K = 6 N = 6
    N = 2 K = 0; (index 2)
    N = 1 K = 0; (index 1)
    K == 0 , return S.charAt(0)
     */
        String S = "a23";
        int K = 6;
        String result = DecodedStringatIndex.decodeAtIndex(S, K);
        System.out.println(result);
    }
}
