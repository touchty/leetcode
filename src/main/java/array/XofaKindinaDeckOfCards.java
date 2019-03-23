package array;

import org.junit.Assert;

import java.util.Arrays;

/**
 * In a deck of cards, each card has an integer written on it.
 * <p>
 * Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:
 * <p>
 * Each group has exactly X cards.
 * All the cards in each group have the same integer.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,4,3,2,1]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[3,3],[4,4]
 * Example 2:
 * <p>
 * Input: [1,1,1,2,2,2,3,3]
 * Output: false
 * Explanation: No possible partition.
 * Example 3:
 * <p>
 * Input: [1]
 * Output: false
 * Explanation: No possible partition.
 * Example 4:
 * <p>
 * Input: [1,1]
 * Output: true
 * Explanation: Possible partition [1,1]
 * Example 5:
 * <p>
 * Input: [1,1,2,2,2,2]
 * Output: true
 * Explanation: Possible partition [1,1],[2,2],[2,2]
 */
// [1,1,1,1,2,2,2,2,2,2] true length of sunarray is {4, 6}, but when X is 2, we can group them successfully.
// so we must try all X from 2 to length of the total array.
public class XofaKindinaDeckOfCards {
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0)
            return false;

        Arrays.sort(deck);
        for (int X = 2; X <= deck.length; X++) {
            if (deck.length % X == 0) {
                int pivot = deck[0];
                int i = 0;
                for (i = 0; i < deck.length; i++) {
                    if ((i % X == 0))
                        pivot = deck[i];
                    if (deck[i] != pivot)
                        break;
                }
                if (i == deck.length)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] deck = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2};
        boolean expected = true;
        boolean res = hasGroupsSizeX(deck);
        Assert.assertEquals(expected, res);
    }
}