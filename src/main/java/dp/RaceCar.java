package dp;

/*
818. Race Car
Hard

243

29

Favorite

Share
Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)

Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).

When you get an instruction "A", your car does the following: position += speed, speed *= 2.

When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)

For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.

Now for some target position, say the length of the shortest sequence of instructions to get there.

Example 1:
Input:
target = 3
Output: 2
Explanation:
The shortest instruction sequence is "AA".
Your position goes from 0->1->3.
Example 2:
Input:
target = 6
Output: 5
Explanation:
The shortest instruction sequence is "AAARA".
Your position goes from 0->1->3->7->7->6.
 */


import org.junit.Assert;

public class RaceCar {
/*
For the input 5, we can reach with only 7 steps: AARARAA. Because we can step back.

Let's say n is the length of target in binary and we have 2 ^ (n - 1) <= target < 2 ^ n
We have 2 strategies here:
1. Go pass our target , stop and turn back
We take n instructions of A.
1 + 2 + 4 + ... + 2 ^ (n-1) = 2 ^ n - 1
Then we turn back by one R instruction.
In the end, we get closer by n + 1 instructions.

2. Go as far as possible before pass target, stop and turn back
We take N - 1 instruction of A and one R.
Then we take m instructions of A, where m < n
 */

    int[] dp = new int[10001];

    public int racecar(int t) {
        if (dp[t] > 0) return dp[t];
        int n = (int) (Math.log(t) / Math.log(2)) + 1;
        // because t<=2^n-1, here n is the number of 'A' we used (no 'R‘’)
        if (1 << n == t + 1) dp[t] = n;
        else {
            // +n 'A' + 1 'R' === +n+1;
            // to reach the target, we may go as far as possible to just reach or pass the target
            // and then we take some steps back, new target: (1 << n) - 1 - t)
            dp[t] = racecar((1 << n) - 1 - t) + n + 1;

            // (n-1) is the number of 'A' before the first 'R';
            // m is the number of 'A' after the first 'R' and before the second 'R';
            // and racecar(...) return the number of steps after the second R;
            // +(n-1) 'A' + 1 'R' + m 'A' + 1 'R' === +n+m+1 (the number of steps before the second 'R'(including it))
            // for instance, to reach 5, we need to take 7 steps: AARARAA
            // to reach the target, we go as far as possible before passing the target (if we just reached it, we can stop)
            // and then we take some steps back (m steps back)
            // and then we continue going forward (by taking a 'R') and so on...
            //
            // diagram:
            // ----------->(n-1)|.......(t)| turn right (n-1) 'A'
            //     |<--------(m)|            turn back m 'A'
            //     |------------------->(t)| turn right and reach the target
            for (int m = 0; m < n - 1; ++m)
                dp[t] = Math.min(dp[t], racecar(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
        }
        return dp[t];
    }

    public static void main(String[] args) {
        int target1 = 3;
        RaceCar solution = new RaceCar();
        int instruction1 = solution.racecar(target1);
        int expected1 = 2;
        Assert.assertEquals(expected1, instruction1);

        int target2 = 6;
        int instruction2 = solution.racecar(target2);
        int expected2 = 5;
        Assert.assertEquals(expected2, instruction2);


    }
}
