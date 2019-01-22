package string;

/**
 * 168. Excel Sheet Column Title
 * Easy
 *
 * 598
 *
 * 120
 *
 * Favorite
 *
 * Share
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
// a little trick to handle corner case 26
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        String res = "";
        while(n > 0) {
            res = String.valueOf((char) (((n - 1) % 26) + 'A')) + res;
            n = (n - 1) / 26;
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 28;
        String res = ExcelSheetColumnTitle.convertToTitle(n);
        System.out.println(res);
    }
}
