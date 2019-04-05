package tree;

/*
427. Construct Quad Tree
Easy

96

246

Favorite

Share
We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node
 represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region
  it represents are all the same.
Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node.
The val attribute for a leaf node contains the value of the region it represents.
Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem
better:
Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
It can be divided according to the definition above:
The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 */
public class ConstructQuadTree {
    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
        }

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }


    public Node construct(int[][] g) {
        return build(0, 0, g.length - 1, g.length - 1, g);
    }

    Node build(int r1, int c1, int r2, int c2, int[][] g) {
        if (r1 > r2 || c1 > c2) return null;
        boolean isLeaf = true;
        int val = g[r1][c1];
        for (int i = r1; i <= r2; i++)
            for (int j = c1; j <= c2; j++)
                if (g[i][j] != val) {
                    isLeaf = false;
                    break;
                }
        if (isLeaf)
            return new Node(val == 1, true, null, null, null, null);
        int rowMid = (r1 + r2) / 2, colMid = (c1 + c2) / 2;
        return new Node(false, false,
                build(r1, c1, rowMid, colMid, g),//top left
                build(r1, colMid + 1, rowMid, c2, g),//top right
                build(rowMid + 1, c1, r2, colMid, g),//bottom left
                build(rowMid + 1, colMid + 1, r2, c2, g));//bottom right
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{0, 1}, {1, 0}};
        ConstructQuadTree solution = new ConstructQuadTree();
        Node root = solution.construct(board);
        System.out.println(root.isLeaf);
    }
}
