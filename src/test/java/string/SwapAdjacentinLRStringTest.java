package string;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwapAdjacentinLRStringTest {
    SwapAdjacentinLRString lr = new SwapAdjacentinLRString();
    @Test
    public void canTransform() {
        String start = "RXXLRXRXL", end = "XRLXXRRLX";
        boolean actual = lr.canTransform(start, end);
        boolean expected = true;
        Assert.assertEquals(expected, actual);
        start = "RXXLRXRRR";
        end = "XRLXXRRLX";
        actual = lr.canTransform(start, end);
        expected = false;
        Assert.assertEquals(expected, actual);
    }
}