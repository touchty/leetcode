import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * UniqueSubstringsinWraparoundString Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 4, 2018</pre>
 */
public class UniqueSubstringsinWraparoundStringTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: findSubstringInWraproundString(String p)
     */
    @Test
    public void testFindSubstringInWraproundString() throws Exception {
        UniqueSubstringsinWraparoundString us = new UniqueSubstringsinWraparoundString();
        String p = "azzaazzaa";  // a z za
        int sum = us.findSubstringInWraproundString(p);
        int sumRe = us.findSubstringInWraproundStringRe(p);
        Assert.assertTrue(sum == 3);
        Assert.assertTrue(sumRe == 3);
    }
} 
