package array;

import java.util.PriorityQueue;

/*
846. Hand of Straights
Medium

251

34

Favorite
Share
Alice has a hand of cards, given as an array of integers.
Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
Return true if and only if she can.
Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 */
public class HandofStraights {
    public boolean isNStraightHandOpt(int[] hand, int W) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : hand) pq.add(num);
        while (!pq.isEmpty()) {
            int smallest = pq.peek();
            for (int i = 0; i < W; i++) {
                if (!pq.contains(smallest + i)) return false;
                else pq.remove(smallest + i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int W = 3;
        HandofStraights straights = new HandofStraights();
        boolean res = straights.isNStraightHandOpt(hand, W);
        System.out.println(res);
    }
}
