package offer;

//题目描述
//给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
public class O8GetNext {
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(0);
        root.left.next = root;

        root.right = new TreeLinkNode(2);
        root.right.next = root;

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;

        TreeLinkNode next1 = GetNext(left);
        if (next1 != null) {
            System.out.println(next1.val); // 1
        } else
            System.out.println("null");

        TreeLinkNode next2 = GetNext(right); // null
        if (next2 != null)
            System.out.println(next2.val);
        else
            System.out.println("null");

        TreeLinkNode next3 = GetNext(root);
        if (next3 != null)
            System.out.println(next3.val);
        else
            System.out.println("null");
    }
}
