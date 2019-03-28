package dp;

import java.util.Arrays;

/*
826. Most Profit Assigning Work
Medium

198

30

Favorite

Share
We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.

Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].

Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.

What is the most profit we can make?

Example 1:

Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100
Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.
 */
public class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] maxProfits = new int[difficulty.length][2];
        for (int i = 0; i < difficulty.length; i++) {
            maxProfits[i][0] = difficulty[i];
            maxProfits[i][1] = profit[i];
        }

        Arrays.sort(maxProfits, (a, b) -> (a[0] - b[0]));

        int previousMax = Integer.MIN_VALUE;
        for (int i = 0; i < difficulty.length; i++) {
            previousMax = Math.max(previousMax, maxProfits[i][1]);
            maxProfits[i][1] = previousMax;
        }

        int sum = 0;
        // sort the worker, and then no need to update p when iterate through worker
        Arrays.sort(worker);
        int p = 0;
        for (int w : worker) {
            while (p < difficulty.length) {
                if (maxProfits[p][0] > w) break;
                p++;
            }
            if (p > 0) sum += maxProfits[p - 1][1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] diff = {68, 35, 52, 47, 86};
        int[] profs = {67, 17, 1, 81, 3};
        int[] ws = {92, 10, 85, 84, 82};
        MostProfitAssigningWork solution = new MostProfitAssigningWork();
        int sum = solution.maxProfitAssignment(diff, profs, ws);
        System.out.println(sum);
    }
}
