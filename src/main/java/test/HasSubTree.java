package test;

//判断子树、子结构
public class HasSubTree {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean result = false;
        // 如果找到了对应Tree2的根节点的点
        if (root1.val == root2.val) {
            // 以这个根节点为为起点判断是否包含Tree2
            result = isSubTree(root1, root2);
        }
        // 如果找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
        if (result == false) {
            result = hasSubtree(root1.right, root2);
        }
        // 如果还找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
        if (result == false) {
            result = hasSubtree(root1.left, root2);
        }
        return result;
    }

    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        // 如果Tree2已经遍历完了都能对应的上，返回true，这个判断条件一定要放在下面那个条件的上面，不然就会出现错误，可能两个
        // 都到达叶子节点了，但是把下面放在前面就会返回false，实际上刚刚好都相同
        if (root2 == null) {
            return true;
        } else if (root1 == null) {// 如果Tree2还没有遍历完，Tree1却遍历完了。返回false
            return false;
        }

        // 如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val) {
            return false;
        }

        // 如果根节点对应的上，那么就分别去子节点里面匹配
        return isSubTree(root1.left, root2.left)
                && isSubTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.right = new TreeNode(2);
        tree1.left = new TreeNode(3);
        tree1.right.right = new TreeNode(4);
        tree1.right.left = new TreeNode(5);
        tree1.left.right = new TreeNode(6);
        tree1.left.left = new TreeNode(7);
        tree1.right.right.right = new TreeNode(8);

        TreeNode tree2 = new TreeNode(3);
        tree2.right = new TreeNode(6);
        tree2.left = new TreeNode(7);

        boolean result = hasSubtree(tree1, tree2);
        System.out.println(result);
    }
}