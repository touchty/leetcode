package binarySearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * FourSumII Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 6, 2018</pre>
 */
public class FourSumIITest {
    FourSumII fourSumII = new FourSumII();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: fourSumCount(int[] A, int[] B, int[] C, int[] D)
     */
    @Test
    public void testFourSumCount() throws Exception {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        int expected = 2;
        int result = fourSumII.fourSumCount(A, B, C, D);
        Assert.assertEquals(expected, result);

    }


} 
