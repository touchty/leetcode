package dp.StateCompressedDp;

import java.util.Arrays;

/*
钱老板赶工
钱老板去国外度了个假，刚回到公司就收到了n封催促工作完成的邮件。
每项工作都有完成截止日期的deadline，钱老板做每项工作都会花去cost天，而且不能中断。
请你帮钱老板安排一下完成工作的顺序，以减少总的工作推迟时间

输入：
n<=20，表示工作数量
接下来n行，每一行有两个数，表示第i项工作的deadline和cost

输出：
最小的总的工作推出时间
标签：动态规划，状态压缩

解析：

由于n比较小，我们用一个int的每一位把n个任务是否已经完成，这就是状态压缩

总状态数有2^n种

状态转移方程：

dp[x] = min\{dp[x - {i}] + sum\_cost(x) - deadline[i]\}`
dp[x]=min{dp[x−i]+sum_cost(x)−deadline[i]}‘

核心代码：
 */
public class TasksScheduling {
    public static int minDelay(int[] deadline, int[] cost) {
        int n = cost.length;
        int[] sum_cost = new int[1 << n];
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int x = 1; x < (1 << n); x++) {
            sum_cost[x] = 0; // 状态x所对应的所有任务的总时间
            for (int i = 0; i < n; i++) {
                if ((x & (1 << i)) != 0) {
                    sum_cost[x] += cost[i]; // 找到对应的任务i
                }
            }
            for (int i = 0; i < n; i++) {
                // 删除其中一个任务，找到上一个状态
                // 当前状态的延迟等于上一状态的延迟，加上当前任务可能的时延
                if ((x & (1 << i)) != 0) {
                    int delay = sum_cost[x] - deadline[i] < 0 ? 0 : sum_cost[x] - deadline[i];
                    dp[x] = Math.min(dp[x], dp[x - (1 << i)] + delay);
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] deadline = {3, 8, 3};
        int[] cost = {3, 1, 2};
        int minDelay = minDelay(deadline, cost);
        System.out.println(minDelay);
    }
}