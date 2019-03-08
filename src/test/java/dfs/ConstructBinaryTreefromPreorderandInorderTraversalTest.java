package dfs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

/** 
* ConstructBinaryTreefromPreorderandInorderTraversal Tester. 
* 
* @author <Authors name> 
* @since <pre>06/01/2018</pre> 
* @version 1.0 
*/ 
public class ConstructBinaryTreefromPreorderandInorderTraversalTest { 
    ConstructBinaryTreefromPreorderandInorderTraversal contructBT = new ConstructBinaryTreefromPreorderandInorderTraversal();
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: buildTree(int[] preorder, int[] inorder) 
* 
*/
void dfs(TreeNode root, List<Integer> list){
    if (root == null) return;
    list.add(root.val);
    dfs(root.left, list);
    dfs(root.right, list);
}
@Test
public void testBuildTree() throws Exception {
    int[] preorder = {3,9,20,15,7};
    int[] inorder = {9,3,15,20,7};
    TreeNode root = contructBT.buildTree(preorder, inorder);

    // preorder of root
    List<Integer> preorderList = new ArrayList<>();
    dfs(root, preorderList);

    for (int i : preorderList){
        System.out.println(i);
    }

    int[] res = new int[preorderList.size()];
    for (int i = 0; i < preorderList.size(); i++) {
        res[i] = preorderList.get(i);
    }
    Assert.assertArrayEquals(preorder, res);
}





/** 
* 
* Method: build(int[] preorder, int[] inorder, int stop) 
* 
*/ 
@Test
public void testBuild() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = ConstructBinaryTreefromPreorderandInorderTraversal.getClass().getMethod("build", int[].class, int[].class, int.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
