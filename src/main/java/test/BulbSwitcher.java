package test;

// CL 319. Bulb Switcher


/*
There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.

Example:

Input: 3
Output: 1
Explanation:
At first, the three bulbs are [off, off, off].
After first round, the three bulbs are [on, on, on].
After second round, the three bulbs are [on, off, on].
After third round, the three bulbs are [on, off, off].
 */

/*
1 2 3
1 = 1*1 ---------奇数个因子
2 = 1*2 ---------偶数个因子
3 = 1*3 ---------偶数个因子
4 = 1*4 , 2*2 ---奇数个因子
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
