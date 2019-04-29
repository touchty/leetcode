package test;

public class Pow {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        double res = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }

    double myPowIterative(double x, long n) {
        if(n==0) return 1;
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        while(n>0){
            if((n&1) != 0) ans *= x;
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        /*double x = 0.00001;
        int n = 2147483647;
        Pow s = new Pow();
        double res = s.myPow(x, n);
        System.out.println(res);*/
        double x = 2.00000;
        int n = -2147483648;
        Pow s = new Pow();
        double res = s.myPow(x, n);
        System.out.println(res);

    }
}
