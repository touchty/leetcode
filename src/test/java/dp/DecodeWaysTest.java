package dp; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* DecodeWays Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 6, 2018</pre> 
* @version 1.0 
*/ 
public class DecodeWaysTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: numDecodings(String s) 
* 
*/ 
@Test
public void testNumDecodings() throws Exception { 
    DecodeWays dw = new DecodeWays();
    String codes = "10";
    int result = dw.numDecodings(codes);
    int result1 = dw.numDecodingsRewrite(codes);
    int expectedResult = 1;
    Assert.assertTrue(expectedResult == result);
    Assert.assertTrue(expectedResult == result1);
}


} 
