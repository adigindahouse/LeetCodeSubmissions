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
public class PathSum {
    //sum is the remaining value we need to get for the original sum
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(isLeaf(root) && (root.val==sum)){
            return true;
        }
        boolean b1=hasPathSum(root.left, sum - root.val);
        if(b1){
            return true;
        }
        
        boolean b2=hasPathSum(root.right, sum - root.val);
        return b2;
    }
    
    public boolean isLeaf(TreeNode node){
        if(node==null){
            return false;
        }
        return (node.left==null) && (node.right==null);
    }
}