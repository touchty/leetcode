package deepFirst;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        populate(root);

    }

    void populate(TreeLinkNode root){
        if(root == null){
            return;
        }

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
            populate(root.left);
            populate(root.right);
        }
    }

    public void connectOpt(TreeLinkNode root) {
        if( root == null )
            return;
        if( root.left != null )
        {
            root.left.next = root.right;
        }

        if( root.right != null)
        {
            if( root.next != null )
            {
                root.right.next = root.next.left;
            }
        }

        connectOpt( root.left );
        connectOpt( root.right );
    }
}
