class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class MaximumDepth {
	public int maxDepth(TreeNode root) {
		//Recursive algorithm

		//Base case: root is null
		if(root == null){
			return 0;
		}

		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);

		return lDepth>rDepth ? lDepth + 1 : rDepth + 1;
	}
}