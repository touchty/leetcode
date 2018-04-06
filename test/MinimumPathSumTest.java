import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MinimumPathSum Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 6, 2018</pre> 
* @version 1.0 
*/ 
public class MinimumPathSumTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: minPathSum(int[][] grid) 
* 
*/ 
@Test
public void testMinPathSum() throws Exception { 
    MinimumPathSum mps = new MinimumPathSum();
    int[][] map = {{1,3,1},{1,5,1},{4,2,1}};
    int result = mps.minPathSum(map);
    //System.out.println(result);
    Assert.assertTrue("Should be 7.",result == 7);
}

} 
