package tree;


public class LowestCommonAncestorOfABinaryTree {
    /**
     * Same solution in several languages. It's recursive and expands the meaning of the function. If the current (sub)
     * tree contains both p and q, then the function result is their LCA. If only one of them is in that subtree, then
     * the result is that one of them. If neither are in that subtree, the result is null/None/nil.
     *
     * Update: I also wrote two iterative solutions now, one of them being a version of the solution here. They're more
     * complicated than this simple recursive solution, but I do find them interesting.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/discuss/65225/4-lines-C++JavaPythonRuby

    public TreeNode lowestCommonAncestorOpt(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) {
            return root;
        }
        TreeNode left, right;
        left = lowestCommonAncestor(root.left,p,q);
        right = lowestCommonAncestor(root.right, p, q);
        if((left==p && right==q ) || (left==q&&right==p)) {
            return root;
        }
        return left==null?right:left;
    }
}