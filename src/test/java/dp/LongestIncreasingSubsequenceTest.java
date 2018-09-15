package dp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestIncreasingSubsequenceTest {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test() throws Exception {
        int[] sequence = {10, 9, 2, 5, 3, 7, 101, 18};

        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

        int len = lis.lengthOfLIS(sequence);

        //Assert.assertTrue(len == 4);
    }
}
