package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, n); i++) {
            String binaryStr = Integer.toBinaryString(i);
            char[] binaryChar = binaryStr.toCharArray();
            int[] binary = new int[binaryStr.length()];
            for (int j = 0; j < binary.length; j++) {
                binary[j] = binaryChar[j] - '0';
            }
            for (int j = binaryChar.length - 1; j >= 1; j--) {
                if (binary[j - 1] == 1)
                    binary[j] = 1 - binary[j];
            }
            int val = 1;
            int decimal = 0;
            for (int j = binary.length - 1; j >= 0; j--) {
                decimal += binary[j] * val;
                val *= 2;
            }
            list.add(decimal);
        }
        return list;
    }

    public static List<Integer> grayCodeOpt(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1 << n; i++) {
            int element = i ^ i >> 1;
            result.add(element);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(grayCodeOpt(2));
    }
}
