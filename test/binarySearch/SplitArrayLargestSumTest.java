package binarySearch; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* SplitArrayLargestSum Tester. 
* 
* @author <Authors name> 
* @since <pre>05/19/2018</pre> 
* @version 1.0 
*/ 
public class SplitArrayLargestSumTest { 
    private SplitArrayLargestSum s = new SplitArrayLargestSum();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: valid(long target, int[] nums, int m) 
* 
*/ 
@Test
public void testValid() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: splitArray(int[] nums, int m) 
* 
*/ 
@Test
public void testSplitArray() throws Exception { 
    int[] nums = {7,2,5,10,8};
    int m = 2;
    int expected = 18;
    int result = s.splitArray(nums, m);
    Assert.assertEquals(expected, result);
} 


} 
