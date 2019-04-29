package algorithms;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {
    boolean found;

    public boolean canCross(int[] stones) {
        found = false;
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > 2 * stones[i - 1])
                return false;
        }
        dfs(stones, 0, 1);
        return found;
    }

    private void dfs(int[] stones, int index, int step) {
        if (step <= 0 || found) return;
        if (index == stones.length - 1) {
            found = true;
            return;
        }
        int reach = stones[index] + step;
        for (int i = index + 1; i < stones.length; i++) {
            if (stones[i] > reach) return;
            if (stones[i] < reach) continue;
            dfs(stones, i, step + 1);
            dfs(stones, i, step);
            dfs(stones, i, step - 1);
        }
    }

    public boolean canCrossOpt(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        // current stone: next reach range
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>(stones.length);
        map.put(0, new HashSet<Integer>());
        map.get(0).add(1);
        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }

        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = step + stone;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                HashSet<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) set.add(step - 1);
                    set.add(step + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        FrogJump frogJump = new FrogJump();
        boolean cross = frogJump.canCrossOpt(stones);
        boolean expected = true;
        Assert.assertEquals(expected, cross);
    }
}
