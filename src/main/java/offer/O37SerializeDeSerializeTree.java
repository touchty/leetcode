package offer;

import tree.TreeNode;

public class O37SerializeDeSerializeTree {
    final String nullFlag = "#";
    final String gap = " ";
    private String deserializeStr;

    // 前序遍历
    public String Serialize(TreeNode root) {
        if (root == null)
            return nullFlag;
        deserializeStr = new StringBuilder().append(root.val).append(gap).append(Serialize(root.left))
                .append(gap).append(Serialize(root.right)).toString();
        return deserializeStr;
    }

    public TreeNode DeSerialize() {
        if (deserializeStr == null || deserializeStr.length() == 0)
            return null;

        // 根节点
        int index = deserializeStr.indexOf(gap);
        String node = (index == -1 ? deserializeStr : deserializeStr.substring(0, index));
        deserializeStr = (index == -1 ? null : deserializeStr.substring(index + 1));
        // 叶子节点（空）判断
        if (node.equals(nullFlag))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = DeSerialize();
        t.right = DeSerialize();

        return t;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        O37SerializeDeSerializeTree solution = new O37SerializeDeSerializeTree();
        String serializeStr = solution.Serialize(root);
        String expected = "2 1 # # 3 # #";
        System.out.println(serializeStr);
        TreeNode recoveredTree = solution.DeSerialize();
        System.out.println(recoveredTree.val);
        System.out.println(recoveredTree.left.val);
        System.out.println(recoveredTree.right.val);
    }
}
