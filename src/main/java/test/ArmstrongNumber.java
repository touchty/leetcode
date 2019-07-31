package test;

import java.util.LinkedList;
import java.util.List;

//
// int num = 12345 ...(5 digits)
// sum = 1^^5 + 2 ^^ 5 + 3^^5 + ...
// sum == num?
public class ArmstrongNumber {
    public static boolean isArmstrongNumber(int number) {
        List<Integer> list = new LinkedList<>();
        int temp = number;
        while (temp > 0) {
            list.add(temp % 10);
            temp /= 10;
        }
        int len = list.size();
        long sum = 0;
        for (int i : list)
            sum += Math.pow(i, len);
        return sum == number;
    }

    public static void main(String[] args) {
        int i = 153;
        boolean res = ArmstrongNumber.isArmstrongNumber(i);
        System.out.println(res);

        int j = 12;
        res = ArmstrongNumber.isArmstrongNumber(j);
        System.out.println(res);
    }
}
