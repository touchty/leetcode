package array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleshipsInABoardTest {
    private BattleshipsInABoard battleshipsInABoard =
            new BattleshipsInABoard();

    @Test
    public void countBattleships() {
        char[][] board =
                new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
        int count = battleshipsInABoard.countBattleships(board);
        int expected = 2;
        Assert.assertEquals(expected, count);
    }
}