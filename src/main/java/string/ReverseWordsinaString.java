package string;

/**
 * 151. Reverse Words in a String
 * Medium
 * <p>
 * 423
 * <p>
 * 1998
 * <p>
 * Favorite
 * <p>
 * Share
 * Given an input string, reverse the string word by word.
 * <p>
 * Example:
 * <p>
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 */
public class ReverseWordsinaString {
    public static String reverseWords(String s) {
        String[] stringArr = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = stringArr.length - 1; i >= 0; i--) {
            if (!stringArr[i].isEmpty())
                builder.append(stringArr[i]).append(" ");
        }
        if (builder.length() > 0)
            builder.delete(builder.length() - 1, builder.length());

        return builder.toString();
    }

    public static void main(String[] args) {
        String str = " 1";
        String res = ReverseWordsinaString.reverseWords(str);
        System.out.println(res);
    }
}
