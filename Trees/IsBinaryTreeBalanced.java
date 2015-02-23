package Trees;
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class RetClass{
    int depth;
    boolean isBalanced;
    
    RetClass(boolean isBalanced, int depth){
        this.isBalanced = isBalanced;
        this.depth = depth;
    }
}

public class IsBinaryTreeBalanced {
    public boolean isBalanced(TreeNode root) {
        RetClass ret = isBalancedModified(root);
        return ret.isBalanced;
    }
    
    public RetClass isBalancedModified(TreeNode root){
        //Base case: if root is null - the the tree is trivially balanced
        if(root==null){
            return new RetClass(true, 0);
        }
        
        //Get the height of the left subtree h1 and if it is balanced - say b1
        RetClass leftDetails = isBalancedModified(root.left);
        
        //if(!b1){ return false, <dummy height>; }
        if(!leftDetails.isBalanced){
            return new RetClass(false, -1);
        }
        
        //Get the height of the left subtree h2 and if it is balanced - say b2
        RetClass rightDetails = isBalancedModified(root.right);

        //if(!b2){ return false, <dummy height>; }
        if(!rightDetails.isBalanced){
            return new RetClass(false, -1);
        }
        
        //b1 && b2
        //return (abs(h1-h2)<=1, max(h1, h2) + 1)
        return new RetClass(Math.abs(leftDetails.depth - rightDetails.depth)<=1, (int)Math.max(leftDetails.depth, rightDetails.depth)+1);
        
    }
}