/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 

public class MinimumDepthBinaryTree {
    int minLevel = 0;
    public int minDepth(TreeNode root) {
        return dfs(root,0);
    }
    
    //dfs will return the number of nodes in the path from the root argument to the leaf node closest to the root
    public int dfs(TreeNode root, int level) {
        //Base case 1: root is null - therefore whatever is the parent's level - that's the result
        if(root == null){
            return level;
        }
        //Base case 2: root is a leaf - therefore whatever is the parent's level - that plus one is the result
        if(isLeaf(root)){
            return level+1;
        }
        //If there is no left subtree only the path from the right subtree counts
        if(root.left==null){
            return dfs(root.right, level+1);
        } 
        //Same way
        else if(root.right==null){
            return dfs(root.left, level+1);
        }
        
        return (int)Math.min(dfs(root.left, level+1), dfs(root.right, level+1));
    }
    
    public boolean isLeaf(TreeNode node){
        if((node.left==null) && (node.right==null)){
            return true;
        }
        return false;
    }
}