package dp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * WiggleSubsequence Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 9, 2018</pre>
 */
public class WiggleSubsequenceTest {

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: wiggleMaxLength(int[] nums)
     */
    @Test
    public void testWiggleMaxLength() throws Exception {
        WiggleSubsequence ws = new WiggleSubsequence();
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int result = ws.wiggleMaxLength(nums);
        int expected = 7;
        Assert.assertTrue(result == expected);
    }

    /**
     * Method: wiggleMaxLengthRewrite(int[] nums)
     */
    @Test
    public void testWiggleMaxLengthRewrite() throws Exception {
        WiggleSubsequence ws = new WiggleSubsequence();
        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        int result = ws.wiggleMaxLengthRewrite(nums);
        int expected = 7;
        Assert.assertTrue(result == expected);
    }


} 
