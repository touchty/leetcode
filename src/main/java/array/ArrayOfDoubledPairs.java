package array;

import org.junit.Assert;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,3,6]
 * Output: false
 * Example 2:
 * <p>
 * Input: [2,1,2,6]
 * Output: false
 * Example 3:
 * <p>
 * Input: [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * Example 4:
 * <p>
 * Input: [1,2,4,16,8,4]
 * Output: false
 */

/*
Intuition
Let's see a simple case
Assume all interger are positive, for example [2,4,4,8].
We have one x = 2, we need to match it with one 2x = 4.
Then one 4 is gone, we have the other x = 4.
We need to match it with one 2x = 8.
Finaly no number left.

Why we start from 2?
Because it's the smallest and we no there is no x/2 left.
So we know we need to find 2x

What if the case negative?
One way is that start from the biggest (with abosolute value smallest),
and we aplly same logic.
-2 <==> -4

Another way is that start from the smallest (with abosolute value biggest),
and we try to find x/2 each turn.
-4 <==> -2

Explanation
Count all numbers.
Loop all numbers on the order of its absolute.
We have counter[x] of x, so we need the same amount of 2x wo match them.
If c[x] > c[2 * x], then we return false
If c[x] <= c[2 * x], then we do c[2 * x] -= c[x] to remove matched 2x.
Don't worry about 0, it doesn't fit the logic above but it won't break our algorithme.

In case count[0] is odd, it won't get matched in the end.
(Anyway you can return false earlier here)

In case count[0] is even, we still have c[0] <= c[2 * 0].
And we still need to check all other numbers.
 */
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
                return false;
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {4, -2, 2, -4};
        boolean actual = new ArrayOfDoubledPairs().canReorderDoubled(A);
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }
}
