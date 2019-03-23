package dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * RangeSumQuery2D Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 12, 2018</pre>
 */
public class RangeSumQuery2DTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: sumRegion(int row1, int col1, int row2, int col2)
     */
    @Test
    public void testSumRegion() throws Exception {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        RangeSumQuery2D rq = new RangeSumQuery2D(matrix);
        int result = rq.sumRegion(1, 2, 2, 4);
        Assert.assertTrue(result == 12);

    }

    /**
     * Method: RangeSumQuery2DRewrite(int[][] matrix)
     */
    @Test
    public void testRangeSumQuery2DRewrite() throws Exception {
    }

    /**
     * Method: sumRegionRewrite(int row1, int col1, int row2, int col2)
     */
    @Test
    public void testSumRegionRewrite() throws Exception {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        RangeSumQuery2D rq = new RangeSumQuery2D(matrix);
        int result = rq.sumRegionRewrite(1, 2, 2, 4);
        Assert.assertTrue(result == 12);
    }


} 
