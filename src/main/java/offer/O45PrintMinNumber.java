package offer;

import java.util.Arrays;
import java.util.Comparator;

public class O45PrintMinNumber {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "Empty number.";
        String[] nStrs = new String[numbers.length];
        int totalLen = 0;
        for (int i = 0; i < numbers.length; i++) {
            nStrs[i] = String.valueOf(numbers[i]);
            totalLen += nStrs[i].length();
        }
        Arrays.sort(nStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder builder = new StringBuilder(totalLen);
        for (String s : nStrs) {
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        O45PrintMinNumber solution = new O45PrintMinNumber();
        String minCombination = solution.PrintMinNumber(numbers);
        String expected = "321323";
        System.out.println(minCombination);
        System.out.println(expected.compareTo(minCombination));
    }
}
