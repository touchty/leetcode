package algorithms;

public class FibonacciNumber {
    public int fib(int N) {
        int prev = 0;
        int curr = 1;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }

        for (int i = 2; i <= N; i++) {
            int temp = prev + curr;
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
