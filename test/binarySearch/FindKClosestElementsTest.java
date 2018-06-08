package binarySearch; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
* FindKClosestElements Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 6, 2018</pre> 
* @version 1.0 
*/ 
public class FindKClosestElementsTest { 
    private FindKClosestElements findKClosestElements = new FindKClosestElements();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findClosestElements(int[] arr, int k, int x) 
* 
*/ 
@Test
public void testFindClosestElements() throws Exception { 
    int[] arr = {1,2,3,4,5};
    int k = 4;
    int x = 3;
    int[] expected = {1,2,3,4};
    List<Integer> resultList = findKClosestElements.findClosestElements(arr,k,x);

    int[] result = new int[resultList.size()];

    for (int i = 0; i < result.length ; i++) {
        result[i] = resultList.get(i);
    }
    Assert.assertArrayEquals(expected, result);
} 


} 
