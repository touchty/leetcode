package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> qu=new LinkedList<>();
        if(root==null) return;
        qu.offer(root);
        while(!qu.isEmpty()){
            int size=qu.size();
            TreeLinkNode temp=null;
            for(int i=0;i<size;i++){
                root=qu.poll();
                root.next=temp;
                temp=root;
                if(root.right!=null) qu.offer(root.right);
                if(root.left!=null) qu.offer(root.left);
            }
        }
    }
}
