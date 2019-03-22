package array;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 841. Keys and Rooms
 * Medium
 * <p>
 * 399
 * <p>
 * 31
 * <p>
 * Favorite
 * <p>
 * Share
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * <p>
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 */
public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return helper(rooms, 0, new HashSet<Integer>());
    }

    private boolean helper(List<List<Integer>> rooms,
                           int key, Set<Integer> seen) {
        seen.add(key);
        List<Integer> keys = rooms.get(key);
        for (int k : keys) {
            if (!seen.contains(k))
                helper(rooms, k, seen);
        }
        return seen.size() == rooms.size();
    }

    public static void main(String[] args) {
        int[] rooms = {1, 2, 3};
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList list = new ArrayList<>();
        list.add(1);
        lists.add(list);

        list = new ArrayList<>();
        list.add(2);
        lists.add(list);

        list = new ArrayList<>();
        list.add(3);
        lists.add(list);

        list = new ArrayList<>();
        lists.add(list);

        KeysandRooms solution = new KeysandRooms();
        boolean res = solution.canVisitAllRooms(lists);
        boolean expected = true;
        Assert.assertEquals(expected, res);
    }
}
