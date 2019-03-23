package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertSortedArrayToBinarySearchTreeTest {
    ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();

    @Test
    public void sortedArrayToBST() {
        int[] nodes = {-10, -3, 0, 5, 9};
        TreeNode root = convertSortedArrayToBinarySearchTree.sortedArrayToBST(nodes);
        System.out.println(root.val);
    }
}