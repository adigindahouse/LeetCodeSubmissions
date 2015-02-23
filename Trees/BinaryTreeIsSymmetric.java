package Trees;
import java.util.*;



public class BinaryTreeIsSymmetric {
	//RECURSIVE:
		//Create a function that tells whether 2 trees are mirror images of each other.
	//Handle the base cases - that should do
	// public boolean areMirrorImages(TreeNode tree1, TreeNode tree2){
	//     //Base case 1:trivially true
	//     if((tree1 == null ) && (tree2 == null)){
	//         return true;
	//     } 
	//     //Base cases 2 and 3: trivially untrue
	//     else if((tree1 != null ) && (tree2 == null)){
	//         return false;
	//     } else if((tree1 == null ) && (tree2 != null)){
	//         return false;
	//     } else {
	//         if(tree1.val!=tree2.val){
	//             return false;
	//         }
	//         return areMirrorImages(tree1.left, tree2.right) && areMirrorImages(tree1.right, tree2.left);
	//     }
	// }

	// public boolean isSymmetric(TreeNode root) {
	//     //if the root's left node is a mirror image of the right node, we are done.
	//     if(root==null){
	//         return true;
	//     }
	//     return areMirrorImages(root.left, root.right);
	// }

	public boolean isSymmetric(TreeNode root) {
		//if the root's left node is a mirror image of the right node, we are done.
		if(root==null){
			return true;
		}
		List<Integer> l1 = inorderTraversal(root.left);
		List<Integer> l2 = reverseInorderTraversal(root.right);

		if(l1.size()!=l2.size()){
			return false;
		}
		for(int i=0;i<l1.size();i++){
			if(l1.get(i).intValue() != l2.get(i).intValue()){
				return false;
			}
		}
		return true;
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> retList = new ArrayList<Integer>();

		if(root==null){
			return retList;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()){
			TreeNode cur = queue.removeLast();
			retList.add(cur.val);
			if(cur.left==null){
				retList.add(Integer.MIN_VALUE);
			} else {
				retList.add(cur.left.val);
				queue.add(cur.left);
			}
			if(cur.right==null){
				retList.add(Integer.MIN_VALUE);
			} else {
				retList.add(cur.right.val);
				queue.add(cur.right);
			}
		}
		return retList;
	}

	public List<Integer> reverseInorderTraversal(TreeNode root) {
		List<Integer> retList = new ArrayList<Integer>();

		if(root==null){
			return retList;
		}

		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()){
			TreeNode cur = queue.removeLast();
			retList.add(cur.val);

			if(cur.right==null){
				retList.add(Integer.MIN_VALUE);
			} else {
				retList.add(cur.right.val);
				queue.add(cur.right);
			}

			if(cur.left==null){
				retList.add(Integer.MIN_VALUE);
			} else {
				retList.add(cur.left.val);
				queue.add(cur.left);
			}

		}
		return retList;
	}
}