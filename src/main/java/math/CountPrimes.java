package math;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
            }
            for (int j = 2; i * j < n; j++) {
                isPrime[i * j] = true;
            }
        }
        return count;
    }
}
