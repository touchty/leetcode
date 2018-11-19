package string;

import bfs.TreeNode;

import java.util.*;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root == null)
                return paths;
            
            dfs(root, "", paths);
            return paths;
        }
        
        void dfs(TreeNode root, String path, List<String> paths) {
            if (root == null) {
                return;
            }
            path += ( root.val + "->");
            
            if (root.left == null && root.right == null) {
                paths.add(path.substring(0, path.length() - 2));
                return;
            }
            else {
                dfs(root.left, path, paths);
                dfs(root.right, path, paths);
            }
        }
}