package bst;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * SymmetricTree Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>05/28/2018</pre>
 */
public class SymmetricTreeTest {
    SymmetricTree symmetricTree = new SymmetricTree();

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isSymmetric(TreeNode root)
     */
    @Test
    public void testIsSymmetric() throws Exception {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        TreeNode left_right = new TreeNode(3);
        TreeNode right_left = new TreeNode(3);
        root.left = left;
        root.right = right;
/*    left.right = left_right;
    right.left = right_left;*/
        boolean expected = true;
        boolean result = symmetricTree.isSymmetric(root);
        Assert.assertEquals(expected, result);
    }


    /**
     * Method: isSymmetricHelp(TreeNode left, TreeNode right)
     */
    @Test
    public void testIsSymmetricHelp() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = SymmetricTree.getClass().getMethod("isSymmetricHelp", TreeNode.class, TreeNode.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
