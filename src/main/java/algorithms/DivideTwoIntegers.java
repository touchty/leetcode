package algorithms;

// 29. Divide Two Integers
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isNg = (dividend < 0) ^ (divisor < 0);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int res = divideHelper(dividend, divisor);
        return isNg ? -1 * res : res;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int res = solution.divide(a, b);
        System.out.println(res);
    }
    // both are less than 0
    private int divideHelper(int dividend, int divisor) {
        if (dividend > divisor) return 0;

        int q = 1;
        int currSum = divisor << 1;
        int prev = divisor;
        while (currSum > dividend && currSum < prev) {
            prev = currSum;
            currSum <<= 1;
            q <<= 1;
        }
        return q + divideHelper(dividend - prev, divisor);
    }
}
