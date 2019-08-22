package offer;

import tree.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class O37SerializeDeSerializeTree {
    final String nullFlag = "#";
    final String gap = " "; // 空格
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
        String nodeStr = (index == -1 ? deserializeStr : deserializeStr.substring(0, index));
        deserializeStr = (index == -1 ? null : deserializeStr.substring(index + 1));
        // 叶子节点（空）判断
        if (nodeStr.equals(nullFlag))
            return null;
        int val = Integer.valueOf(nodeStr);
        TreeNode t = new TreeNode(val);
        t.left = DeSerialize();
        t.right = DeSerialize();

        return t;
    }

    public class Codec {
        private static final String spliter = ",";
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(spliter);
            } else {
                sb.append(node.val).append(spliter);
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Deque<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(spliter)));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Deque<String> nodes) {
            String val = nodes.remove();
            if (val.equals(NN)) return null;
            else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
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
