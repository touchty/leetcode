package stack;

import org.junit.Assert;

import java.util.Deque;
import java.util.LinkedList;

/*
739. Daily Temperatures
Medium

1051

27

Favorite

Share
Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you
would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be
[1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range
[30, 100].
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peekFirst()]) {
                // when T[i] > T[stack.peekFirst()]), we can get the days before of idx
                // otherwise, just push it into the stack, and wait for next larger
                // temperature to come. If there is no such element, the result remains 0.
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures solution = new DailyTemperatures();
        int[] res = solution.dailyTemperatures(T);
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        Assert.assertArrayEquals(expected, res);
    }
}
