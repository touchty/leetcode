package string;

/**
 * 168. Excel Sheet Column Title
 * Easy
 * <p>
 * 598
 * <p>
 * 120
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * Example 1:
 * <p>
 * Input: 1
 * Output: "A"
 * Example 2:
 * <p>
 * Input: 28
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: 701
 * Output: "ZY"
 */
// a little trick to handle corner case 26
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
            res = String.valueOf((char) (((n - 1) % 26) + 'A')) + res;
            n = (n - 1) / 26;
        }
        return res;
    }

    public static String convertToTitleOpt(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
    }

    /*
    这道题目的本质是求一个整数的26进制数，但是和普通的26进制�?不同之处在于它是1-based的�?�不�?0-based的�?�因此，
    我们�?要首先执�?--n，将�?低位变成0-based，然后进行转换，在转换之后，又需要执行（remain + 65）将�?低位转换�?1-based的�??
    在最低位处理完成之后，再用（n/26）计算次低位，直到处理完成所有的位数�?

class Solution {
public:
    string convertToTitle(int n) {
        string ret;
        int remain = 0;
    	do {
    		remain = (--n) % 26;
    		ret.push_back(remain + 65);
    		n /= 26;
    	} while(n > 0);
    	reverse(ret.begin(), ret.end());
    	return ret;
    }
     */

    public static void main(String[] args) {
        int n = 28;
        String res = ExcelSheetColumnTitle.convertToTitleOpt(n);
        System.out.println(res);
    }
}
