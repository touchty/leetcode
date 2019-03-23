package greedy;

import java.util.Arrays;

/**
 * 881. Boats to Save People
 * Medium
 * <p>
 * 180
 * <p>
 * 21
 * <p>
 * Favorite
 * <p>
 * Share
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * <p>
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 * <p>
 * Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 * Example 2:
 * <p>
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 * Example 3:
 * <p>
 * Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 */

/*
Push from two ends of the sorted array people.

if the 2 ends, people[lo] and people[hi], can fit in a boat, move the 2 ends;
otherwise move only the high end, and the low end stays.
In other words: always move the high end, but the low end depends on if it can cram into a boat with the high end.
repeat the above till the 2 ends meet.
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        for (int hi = people.length - 1, lo = 0; hi >= lo; --hi, ++ans) { // high end always moves
            if (people[lo] + people[hi] <= limit) { ++lo; } // low end moves only if it can fit in a boat with high end.
        }
        return ans;
    }
Update:
Since some people challenge or have questions about the greedy algorithm, I provide the proof as follows.

Proof of the correctness of the greedy algorithm:
Denote S as one of the optimal solutions, and O as our algorithm output solution.
1. Greedy choice property.

Starting from the heaviest person hi, there are 2 possible cases:
a) if hi can NOT fit in a boat with any other, then both in S and O, hi is in a boat alone. Apparently, our first step is optimal and the greedy choice property holds;
b) if hi CAN fit in a boat with at least 1 other person, then
in O, hi and lightest person lo together must be in same boat, according to our algorithm.

In S, if they are also in same boat, then our first step is optimal and the greedy choice property holds;
If hi and lo are not in same boat, say in boat-hi and boat-lo respectively, then we can swap hi with lo's boat mate, say m. Obviously, m <= hi, therefore the swap is feasible. Since the swap results no extra boat(s), a new optimal solution T is obtained. That indicates our first step--put hi and lo into same boat--is an optimal step and and greedy choice property also holds.

2.optimal substructure property.

Let P be the original problem at scale n, where n = people.length. From the above 1, after first step, we have a subproblem P' at scale n'(n' = n - 1 or n - 2, depends on hi in a boat alone or not). Similary, we have hi' and lo' and can do next step as in 1.

Since in 1 we proved T is an optimal solution, and the solution of P', say O', contained within T is also an optimal one. Thus the the problem has the optimal substructure property.

Combine 1 and 2, we complete the proof.

end of proof.
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans = 0;
        for (int hi = people.length - 1, lo = 0; hi >= lo; --hi, ++ans) { // high end always moves
            if (people[lo] + people[hi] <= limit) {
                ++lo;
            } // low end moves only if it can fit in a boat with high end.
        }
        return ans;
    }
}
