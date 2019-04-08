package stack;

import bfs.TreeNode;

import java.util.*;

/*
889. Construct Binary Tree from Preorder and Postorder Traversal
Medium

347

19

Favorite

Share
Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.



Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]


Note:

1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
Accepted
13.2K
Submissions
22.5K
 */
public class ConstructBinaryTreefromPreorderandPostorderTraversal {

    /*
    Solution:
    lee215
    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/discuss/161268/C%2B%2BJavaPython-One-Pass-Real-O(N)
    I see a lot of solution saying O(N), but actually not.
    If it takes already O(N) time to find left part and right right, it could not be O(N).
    If it is recursive solution, it should use a hashmap to reduce complexity, otherwise in most cases it has at least average O(NlogN).

    Here I share my iterative solution.
    We will preorder generate TreeNodes, push them to stack and postorder pop them out.

    Loop on pre array and construct node one by one.
    stack save the current path of tree.
    node = new TreeNode(pre[i]), if not left child, add node to the left. otherwise add it to the right.
    If we meet a same value in the pre and post, it means we complete the construction for current subtree. We pop it from stack.
    Complexity:
    O(N) Time O(N) Space
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> s = new ArrayDeque<>();
        s.push(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.peek().val == post[j]) {
                s.poll();
                j++;
            }
            if (s.peek().left == null) s.peek().left = node;
            else s.peek().right = node;
            s.push(node);
        }
        while (s.size() > 1) {
            s.poll();
        }
        return s.poll();
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3};
        int[] post = {2, 3, 1};
        ConstructBinaryTreefromPreorderandPostorderTraversal s = new ConstructBinaryTreefromPreorderandPostorderTraversal();
        TreeNode root = s.constructFromPrePost(pre, post);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
