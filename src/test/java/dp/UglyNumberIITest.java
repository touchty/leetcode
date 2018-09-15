package dp; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* UglyNumberII Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 9, 2018</pre> 
* @version 1.0 
*/ 
public class UglyNumberIITest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: nthUglyNumber(int n) 
* 
*/ 
@Test
public void testNthUglyNumber() throws Exception { 
    UglyNumberII un = new UglyNumberII();
    int[] expected = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15};
    for (int i = 0; i < expected.length; i++) {
        Assert.assertTrue(un.nthUglyNumber(i + 1) == expected[i]);
        Assert.assertTrue(un.nthUglyNumberRewrite(i + 1) == expected[i]);
    }
} 

/** 
* 
* Method: nthUglyNumberRewrite(int n) 
* 
*/ 
@Test
public void testNthUglyNumberRewrite() throws Exception { 
//TODO: Test goes here... 
} 


} 
