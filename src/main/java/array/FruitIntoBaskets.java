package array;

import java.util.HashMap;
import java.util.Map;

/*
904. Fruit Into Baskets
Medium

356

509

Favorite

Share
In a row of trees, the i-th tree produces fruit with type tree[i].

You start at any tree of your choice, then repeatedly perform the following steps:

Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.

You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.

What is the total amount of fruit you can collect with this procedure?



Example 1:

Input: [1,2,1]
Output: 3
Explanation: We can collect [1,2,1].
Example 2:

Input: [0,1,2,2]
Output: 3
Explanation: We can collect [1,2,2].
If we started at the first tree, we would only collect [0, 1].
Example 3:

Input: [1,2,3,2,2]
Output: 4
Explanation: We can collect [2,3,2,2].
If we started at the first tree, we would only collect [1, 2].
Example 4:

Input: [3,3,3,1,2,1,1,2,3,3,4]
Output: 5
Explanation: We can collect [1,2,1,1,2].
If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 */
public class FruitIntoBaskets {
    /**
     * Solution:
     * Problem
     * "Start from any index, we can collect at most two types of fruits. What is the maximum amount"
     * <p>
     * Translation
     * Find out the longest length of subarrays with at most 2 different numbers?
     * <p>
     * Solution of sliding window will be easier to understand.
     * Here I share another solution wihtout hash map.
     * Hope it's not damn hard to understand.
     * <p>
     * Explanation:
     * Loop all fruit c in tree,
     * Note that a and b are the last two different types of fruit that we met,
     * c is the current fruit type,
     * so it's something like "....aaabbbc..."
     * <p>
     * Case 1 c == b:
     * fruit c already in the basket,
     * and it's same as the last type of fruit
     * cur += 1
     * count_b += 1
     * <p>
     * Case 2 c == a:
     * fruit c already in the basket,
     * but it's not same as the last type of fruit
     * cur += 1
     * count_b = 1
     * a = b, b = c
     * <p>
     * Case 3 c != b && c!= a:
     * fruit c not in the basket,
     * cur = count_b + 1
     * count_b = 1
     * a = b, b = c
     * <p>
     * Of course, in each turn we need to update res = max(res, cur)
     * longest sub array with at most 2 types.
     *
     * @param tree ith position is of type tree[i]
     * @return longest sub array with at most 2 types.
     */

    public int totalFruit(int[] tree) {
        int res = 0, cur = 0, count_b = 0, a = 0, b = 0;
        for (int c : tree) {
            cur = c == a || c == b ? cur + 1 : count_b + 1;
            count_b = c == b ? count_b + 1 : 1;
            if (b != c) {
                a = b;
                b = c;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    /**
     * Problem
     * "Start from any index, we can collect at most two types of fruits. What is the maximum amount"
     * <p>
     * Translation
     * Find out the longest length of subarrays with at most 2 different numbers?
     * <p>
     * Complexity:
     * O(N) time, O(1) space
     *
     * @param tree
     * @return
     */
    public int totalFruitSlidingWindow(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] tree = {1, 2, 1};
        int res = new FruitIntoBaskets().totalFruit(tree);
        System.out.println(res);
    }
}
