package array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageOverlapTest {
    private ImageOverlap imageOverlap = new ImageOverlap();

    @Test
    public void largestOverlap() {
        int[][] A = {
                {1, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] B = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 1}
        };

        int expected = 3;
        int res = imageOverlap.largestOverlap(A, B);
        Assert.assertEquals(expected, res);
    }
}