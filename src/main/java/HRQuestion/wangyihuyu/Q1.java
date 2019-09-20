package HRQuestion.wangyihuyu;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1 {
    /*static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            a = a % b;
            b = a;
            a = temp;
        }
        return a;
    }

    static long minMulti(long a, long b) {
        return a * b / gcd(a, b);
    }*/

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            a = a % b;
            b = a;
            a = temp;
        }
        return a;
    }

    static BigInteger minMulti(Long a, Long b) {
        BigInteger bigA = new BigInteger(String.valueOf(a));
        BigInteger bigB = new BigInteger(String.valueOf(b));
        BigInteger multiply = bigA.multiply(bigB);
        long gcd = gcd(a, b);
        BigInteger bigGcd = new BigInteger(String.valueOf(gcd));
        BigInteger res = multiply.divide(bigGcd);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        System.out.println(gcd(a, b) + " " + minMulti(a, b));
    }
}
