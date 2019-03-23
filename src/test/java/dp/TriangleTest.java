package dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Triangle Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 6, 2018</pre>
 */
public class TriangleTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: minimumTotal(List<List<Integer>> triangle)
     */
    @Test
    public void testMinimumTotal() throws Exception {
        List<List<Integer>> triangle = new ArrayList<>();

        int[][] row = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        for (int i = 0; i < row.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < row[i].length; j++) {
                temp.add(row[i][j]);
            }
            triangle.add(temp);
        }

        Triangle tri = new Triangle();
        int result = tri.minimumTotal(triangle);
        int expected = 11;
        Assert.assertTrue(result == expected);
    }

} 
