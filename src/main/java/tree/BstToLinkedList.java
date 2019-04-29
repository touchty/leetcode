package tree;

public class BstToLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode lastNodeOfList = null;// LastNodeOfList指向已经转换好的链表的最后一个结点
        // 返回头结点
        TreeNode headNodeOfList = ConvertNode(pRootOfTree, lastNodeOfList);
        // 一直倒退到头结点
        while (headNodeOfList != null && headNodeOfList.left != null)
            headNodeOfList = headNodeOfList.left;

        return headNodeOfList;
    }

    // 把二叉树转换成链表,获得链表最后结点（即最大结点）
    TreeNode ConvertNode(TreeNode pNode, TreeNode LastNodeOfList) {
        if (pNode == null)
            return null;
        TreeNode current = pNode;

        if (current.left != null)
            // 把左子树转成链表
            LastNodeOfList = ConvertNode(current.left, LastNodeOfList);
        // 当前结点的左边就是左子树构成的链表的最后一个结点
        current.left = LastNodeOfList;

        if (LastNodeOfList != null)
            // 把转换好的链表后面连接当前结点
            LastNodeOfList.right = current;
        // 此时根转换好的链表最后一个结点就是当前结点
        LastNodeOfList = current;
        // 同理 把右子树转成链表
        if (current.right != null)
            LastNodeOfList = ConvertNode(current.right, LastNodeOfList);
        return LastNodeOfList;
    }

    public static void main(String[] args) {
        TreeNode pRootOfTree = new TreeNode(10);
        pRootOfTree.left = new TreeNode(6);
        pRootOfTree.right = new TreeNode(14);
        pRootOfTree.left.left = new TreeNode(4);
        pRootOfTree.left.right = new TreeNode(8);
        pRootOfTree.right.left = new TreeNode(12);
        pRootOfTree.right.right = new TreeNode(16);

        BstToLinkedList treetolist = new BstToLinkedList();
        TreeNode result = treetolist.Convert(pRootOfTree);
        System.out.print(result.val + " " + result.right.val + " " + result.right.right.val + " "
                + result.right.right.right.val + " " + result.right.right.right.right.val + " "
                + result.right.right.right.right.right.val + " " + result.right.right.right.right.right.right.val);

    }
}
