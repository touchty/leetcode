package array;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 *
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 *
 *
 * Note:
 *
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class AdvantageShuffle {
    public static int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        Arrays.sort(A);
        int[] ans = new int[len];
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            int b = B[i];
            int idx = find(A, used, b);
            used[idx] = true;
            ans[i] = A[idx];
        }
        return ans;
    }

    private static int find(int[] A, boolean[] used, int b) {
        int idx = Arrays.binarySearch(A, b);
        if (idx < 0) {
            idx = -(idx + 1); //If key is not present, the it returns "(-(insertion point) - 1)".
        } else {
            idx++;
        }

        while (idx < A.length) {
            if (!used[idx] && A[idx] > b) {
                return idx;
            }
            idx++;
        }

        // otherwise return the lowest not used
        for (int i = 0; i < A.length; i++) {
            if (!used[i]) return i;
        }
        return -1;
    }
    public int[] advantageCountOpt(int[] A, int[] B) {

        // the tree map stores <value, count> pairs of array A
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // for each value in B, get the A entry with smallest higher key or the smallest key if not exist
        int[] res = new int[A.length];

        for (int i = 0; i < B.length; i++) {
            Map.Entry<Integer, Integer> matchingEntry = map.higherEntry(B[i]);
            if (matchingEntry == null) {
                matchingEntry = map.firstEntry();
            }

            res[i] = matchingEntry.getKey();
            if (matchingEntry.getValue() == 1) {
                map.remove(matchingEntry.getKey());
            } else {
                map.put(matchingEntry.getKey(), matchingEntry.getValue() - 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {2,7,11,15}, B = {1,10,4,11};
        int[] res = advantageCount(A, B);
        int[] expected = {2,11,7,15};
        Assert.assertArrayEquals(expected, res);
    }
}
