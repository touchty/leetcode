package dfs;
/*
* Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
* ordered from top to bottom.
* */

import java.util.*;

/*
* Solution :https://leetcode.com/problems/binary-tree-right-side-view/discuss/56012/My-simple-accepted-solution(JAVA)
* The core idea of this algorithm:
*
* 1.Each depth of the tree only select one node.
* 2. View depth is current size of result list.
* */

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        // right node first!
        // if right node is not null, list of result  increase by one, so the left node is not valid,
        // for this depth already has a node.
        rightView(curr.right, result, currDepth + 1);

        rightView(curr.left, result, currDepth + 1);

    }
    public void rightViewRewrite(TreeNode curr, List<Integer> result, int currDepth){
        if (curr == null){
            return;
        }
        if (result.size() == currDepth){
            result.add(curr.val);
        }
        rightViewRewrite(curr.right, result, currDepth + 1);
        rightViewRewrite(curr.left, result, currDepth + 1);
    }
}
