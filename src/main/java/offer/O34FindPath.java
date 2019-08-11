package offer;

import tree.TreeNode;

import java.util.ArrayList;

public class O34FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null)
            return lists;
        helper(lists, new ArrayList<Integer>(), root, target);
        return lists;
    }

    private void helper(ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, TreeNode root, int target) {
        if (root == null)
            return;
        list.add(root.val);

        if (root.left == null && root.right == null && root.val == target) {
            lists.add(new ArrayList<>(list));
        }

        helper(lists, list, root.left, target - root.val);

        helper(lists, list, root.right, target - root.val);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(7);

        O34FindPath soluiton = new O34FindPath();
        ArrayList<ArrayList<Integer>> lists = soluiton.FindPath(root, 6);
        System.out.println(lists);
    }
}
