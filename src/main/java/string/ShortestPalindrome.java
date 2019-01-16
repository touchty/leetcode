package string;

/**
 * 214. Shortest Palindrome
 * Hard
 * 522
 * 67
 * Favorite
 * Share
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return
 * the shortest palindrome you can find by performing this transformation.
 * Example 1:
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 * Input: "abcd"
 * Output: "dcbabcd"
 */
public class ShortestPalindrome {
    public static String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith(r.substring(i))) {
                return r.substring(0, i) + s;
            }
        }
        // System.out.println("Never execute!");
        return r + s;
    }

    public static void main(String[] args) {
        String s = "abc";
        String res = ShortestPalindrome.shortestPalindrome(s);
        System.out.println(res);
    }
}
