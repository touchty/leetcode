package tree;

public class PathSumIII {
    int totalPaths = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return totalPaths;
        paths(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return totalPaths;
    }

    void paths(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            totalPaths++;
        }
        paths(root.left, sum);
        paths(root.right, sum);
    }

    // solution 2 (ty)
    /*public int pathSum(TreeNode root, int sum){
        int[] arr = new int[1];
        pathSumHelper(root, sum, arr);
        return arr[0];
    }

    public int pathSumHelper(TreeNode root, int sum, int[] arr) {
        if (root == null) return arr[0];
        paths(root, sum, arr);
        pathSumHelper(root.left, sum, arr);
        pathSumHelper(root.right, sum, arr);
        return arr[0];
    }

    void paths(TreeNode root, int sum, int[] arr) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0 ) {
            arr[0]++;
        }
        paths(root.left, sum, arr);
        paths(root.right, sum, arr);
    }*/


    // solution 3
    /*static int count=0;
    public int pathSum(TreeNode root, int sum) {
        int[] path= new int[depth(root)];
        count=0;
        pathSum(root,0,sum,path);
        return count;
    }

    public void pathSum(TreeNode root, int level, int sum, int[] path)
    {
        if(root==null)
            return ;
        path[level]= root.val;

        int t=0;
        for(int i=level;i>=0;i--)
        {
            t=t+path[i];

            if(t==sum)
                count++;
        }

        pathSum(root.left, level+1,sum, path);
        pathSum(root.right, level+1, sum, path);
        path[level]=Integer.MIN_VALUE; // not necessary

    }

    public int depth(TreeNode root)
    {
        if(root==null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }*/
    // 8 ms
}
