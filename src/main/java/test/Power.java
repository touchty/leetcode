package test;

public class Power {
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (base < Math.pow(10, -30) && base > -Math.pow(10, -30))
            return 0;
        if (exponent == 1)
            return base;
        if (exponent < 0) {
            base = 1/ base;
            exponent = -1 * exponent;
        }
        double tmp = Power(base*base, exponent/2);
        if (exponent % 2 == 1)
            tmp *= base;
        return tmp;
    }

    public static void main(String[] args) {
        double base = 2;
        int exp = -3;
        System.out.println(Power(base, exp));
    }
}
