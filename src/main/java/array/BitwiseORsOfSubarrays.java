package array;

import java.util.HashSet;
import java.util.Set;

/**
 * We have an array A of non-negative integers.
 * <p>
 * For every (contiguous) subarray B = [A[i], A[i+1], ..., A[j]] (with i <= j), we take the bitwise OR of all the elements in B, obtaining a result A[i] | A[i+1] | ... | A[j].
 * <p>
 * Return the number of possible results.  (Results that occur more than once are only counted once in the final answer.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [0]
 * Output: 1
 * Explanation:
 * There is only one possible result: 0.
 * Example 2:
 * <p>
 * Input: [1,1,2]
 * Output: 3
 * Explanation:
 * The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
 * These yield the results 1, 1, 2, 1, 3, 3.
 * There are 3 unique values, so the answer is 3.
 * Example 3:
 * <p>
 * Input: [1,2,4]
 * Output: 6
 * Explanation:
 * The possible results are 1, 2, 3, 4, 6, and 7.
 */
public class BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>(), cur = new HashSet<>(), cur2;
        for (Integer i : A) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (Integer j : cur) cur2.add(i | j);
            res.addAll(cur = cur2);
        }
        return res.size();
    }
}
