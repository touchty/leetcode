package dp;

public class Pow {
    public double myPow(double x, int n) {
        int sign = n >= 0 ? 1 : -1;
        n = Math.abs(n);
        double result = myPowHelperOptimized(x, n);
        if (sign == 1)
            return result;
        else
            return 1 / result;

    }

    public double myPowHelper(double x, int n) {
        if (n <= 0)
            return 1L;

        double result = x;
        int multiple = 1;
        while (multiple + multiple <= n) {
            result *= result;
            multiple += multiple;
        }

        return result * myPowHelper(x, n - multiple);
    }

    public double myPowHelperOptimized(double x, int n) {
        if (n <= 0)
            return 1L;

        double powxn = 1.0;
        while (n >= 2) {
            double result = x;
            int multiple = 1;
            while (multiple + multiple <= n) {
                result *= result;
                multiple += multiple;
            }
            n -= multiple;
            powxn = powxn * result;
        }

        if (n == 1) {
            powxn *= x;
        }
        return powxn;
    }

    public double powAC(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {  // catch under flow
                n += 2;
            }
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? powAC(x * x, n / 2) : x * powAC(x * x, n / 2);
    }

}
