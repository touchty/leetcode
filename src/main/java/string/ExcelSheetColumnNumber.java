package string;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * Example 1:
 * <p>
 * Input: "A"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "AB"
 * Output: 28
 * Example 3:
 * <p>
 * Input: "ZY"
 * Output: 701
 */
public class ExcelSheetColumnNumber {
    final int ALPHABET = 26;

    public int titleToNumber(String s) {
        int Len = s.length();
        int weight = 1;
        int count = 0;

        for (int i = Len - 1; i >= 0; i--) {
            int val = s.charAt(i) - 'A' + 1;
            count += val * weight;
            weight *= ALPHABET;
        }

        return count;
    }
}
