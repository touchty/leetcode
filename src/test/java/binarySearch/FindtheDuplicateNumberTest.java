package binarySearch;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * FindtheDuplicateNumber Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>���� 2, 2018</pre>
 */
public class FindtheDuplicateNumberTest {
    private FindtheDuplicateNumber findtheDuplicateNumber = new FindtheDuplicateNumber();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findDuplicate(int[] nums)
     */
    @Test
    public void testFindDuplicate() throws Exception {
        int[] nums = {1, 3, 4, 2, 2};
        int expected = 2;
        int result = findtheDuplicateNumber.findDuplicate(nums);
        Assert.assertEquals(expected, result);
    }


} 
