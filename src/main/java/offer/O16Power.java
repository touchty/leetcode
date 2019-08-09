package offer;

public class O16Power {
    public static double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        if (base == 1)
            return 1;
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        double temp = Power(base * base, exponent / 2);
        if (exponent % 2 == 0)
            return temp;
        else
            return base * temp;
    }

    public static void main(String[] args) {
        double base = 2.0;
        int exponent = -3;
        double pow = O16Power.Power(base, exponent);
        System.out.println(pow);
    }
}
