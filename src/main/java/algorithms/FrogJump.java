package algorithms;

import org.junit.Assert;

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

    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        FrogJump frogJump = new FrogJump();
        boolean cross = frogJump.canCross(stones);
        boolean expected = true;
        Assert.assertEquals(expected, cross);
    }
}
