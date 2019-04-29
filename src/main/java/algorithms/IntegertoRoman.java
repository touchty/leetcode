package algorithms;

import org.junit.Assert;

public class IntegertoRoman {
    public static String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    public static void main(String[] args) {
        int i = 1024;
        String roman = IntegertoRoman.intToRoman(i);
        String expected = "MXXIV";
        Assert.assertEquals(expected, roman);
        System.out.println(roman);
    }
}
