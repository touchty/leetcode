package broadfirstsearch; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.omg.CORBA.PRIVATE_MEMBER;

/** 
* CourseSchedule Tester. 
* 
* @author <Authors name> 
* @since <pre>05/30/2018</pre> 
* @version 1.0 
*/ 
public class CourseScheduleTest { 
    private CourseSchedule courseSchedule = new CourseSchedule();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: canFinish(int numCourses, int[][] prerequisites) 
* 
*/ 
@Test
public void testCanFinish() throws Exception {
    int numCourses = 2;
    int[][] prerequisites = {{0,1}};
    boolean expected = true;
    boolean result = courseSchedule.canFinish(numCourses,prerequisites);
    Assert.assertEquals(expected, result);

    numCourses = 2;
    prerequisites = new int[][]{{0,1},{1,0}};
    expected = false;
    result = courseSchedule.canFinish(numCourses, prerequisites);
    Assert.assertEquals(expected, result);
} 

/** 
* 
* Method: canFinishBFS(int numCourses, int[][] prerequisites) 
* 
*/ 
@Test
public void testCanFinishBFS() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: dfs(List<Integer>[] adj, boolean[] visited, int course) 
* 
*/ 
@Test
public void testDfs() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = CourseSchedule.getClass().getMethod("dfs", List<Integer>[].class, boolean[].class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
