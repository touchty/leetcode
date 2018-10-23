package array;

/**
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 *
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one of its adjacent washing machines at the same time .
 *
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not possible to do it, return -1.
 *
 * Example1
 *
 * Input: [1,0,5]
 *
 * Output: 3
 *
 * Explanation:
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 * Example2
 *
 * Input: [0,3,0]
 *
 * Output: 2
 *
 * Explanation:
 * 1st move:    0 <-- 3     0    =>    1     2     0
 * 2nd move:    1     2 --> 0    =>    1     1     1
 * Example3
 *
 * Input: [0,2,0]
 *
 * Output: -1
 *
 * Explanation:
 * It's impossible to make all the three washing machines have the same number of dresses.
 * Note:
 * The range of n is [1, 10000].
 * The range of dresses number in a super washing machine is [0, 1e5].
 * https://blog.csdn.net/TstsUgeg/article/details/62427718
 */
public class SuperWashingMachines {
    public static int findMinMoves(int[] machines) {
        if (machines == null || machines.length <= 1)
            return 0;

        int sum = 0;
        for (int element : machines)
            sum += element;
        int n = machines.length;
        if (sum % n != 0)
            return -1;

        int avg = sum / n;

        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + machines[i];
        }

        int minMoving = 0;

        for (int i = 0; i < n; i ++) {
            int tempMinMoving = 0;
            int lCnt = sums[i] - i * avg;
            int rCnt = sums[n] - sums[i + 1] - avg * (n - 1 - i);
            if (lCnt > 0 && rCnt > 0) {
                tempMinMoving = Math.max(lCnt, rCnt);
            }
            else if (lCnt < 0 && rCnt < 0) {
                tempMinMoving = 0 - lCnt - rCnt;
            }
            else {
                tempMinMoving = Math.max(Math.abs(lCnt), Math.abs(rCnt));
            }

            minMoving = Math.max(minMoving, tempMinMoving);
        }

        return minMoving;
    }

    public static void main(String[] args) {
        int[] machines = {0,3,0};
        System.out.println(findMinMoves(machines));
    }
}
