package algorithms;

public class Power {
    public static double power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;
    }

    //解释 https://leetcode.wang/leetCode-50-Pow.html
    public double MyPow(double x, int n) {
        double ans = 1;
        long absN = Math.abs((long) n);
        while (absN > 0) {
            if ((absN & 1) == 1) ans *= x;
            absN >>= 1;
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }

    public static void main(String[] args) {
        double res = Power.power(2, 3);
        System.out.println(res);
    }
}