package pq;

import java.util.PriorityQueue;

/*
502. IPO
Hard

169

18

Favorite

Share
Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.

Example 1:
Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

Output: 4

Explanation: Since your initial capital is 0, you can only start the project indexed 0.
             After finishing it you will obtain profit 1 and your capital becomes 1.
             With capital 1, you can either start the project indexed 1 or the project indexed 2.
             Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
             Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 */
public class IPO {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        // {Capital, Profit}
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> (a[0] - b[0])); // Capital, min pq
        PriorityQueue<Integer> pqPro = new PriorityQueue<>((a, b) -> (b - a)); // Profit, max pq

        for (int i = 0; i < Profits.length; i++) {
            pqCap.add(new int[]{Capital[i], Profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                // candidate lucrative projects
                pqPro.add(pqCap.poll()[1]);
            }

            if (pqPro.isEmpty()) break; // no lucrative project

            W += pqPro.poll(); // the most lucrative project
        }
        return W;
    }
}
