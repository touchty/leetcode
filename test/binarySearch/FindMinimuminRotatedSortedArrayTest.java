package binarySearch; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* FindMinimuminRotatedSortedArray Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 7, 2018</pre> 
* @version 1.0 
*/ 
public class FindMinimuminRotatedSortedArrayTest { 
    private FindMinimuminRotatedSortedArray find = new FindMinimuminRotatedSortedArray();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findMin(int[] nums) 
* 
*/ 
@Test
public void testFindMin() throws Exception { 
    int[] nums = {7,8,9,10,1,2,3,4,5,6};
    int expected = 1;
    int result = find.findMin(nums);
    Assert.assertEquals(expected, result);
} 


} 
