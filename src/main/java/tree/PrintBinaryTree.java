package tree;

import java.util.*;

/*
655. Print Binary Tree
Medium

199

471

Favorite

Share
Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.
Example 1:
Input:
     1
    /
   2
Output:
[["", "1", ""],
 ["2", "", ""]]
Example 2:
Input:
     1
    / \
   2   3
    \
     4
Output:
[["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
Example 3:
Input:
      1
     / \
    2   5
   /
  3
 /
4
Output:

[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 */
public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        int depth = depth(root);
        int width = (int) (Math.pow(2, depth) - 1); // every line should be of the length of all elements
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < depth; i++) {
            List<String> temp = new ArrayList<String>();
            for (int j = 0; j < width; j++) {
                temp.add("");
            }
            res.add(temp);
        }
        update(root, 0, 0, width - 1, res);
        return res;
    }

    // return root's depth
    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }

    // update printing
    void update(TreeNode root, int row, int left, int right, List<List<String>> res) {
        if (root == null) {
            return;
        }
        int mid = left + (right - left) / 2;
        res.get(row).set(mid, String.valueOf(root.val));
        update(root.left, row + 1, left, mid - 1, res);
        update(root.right, row + 1, mid + 1, right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        PrintBinaryTree printer = new PrintBinaryTree();
        List<List<String>> res = printer.printTree(root);
        System.out.println(res);
    }
}
