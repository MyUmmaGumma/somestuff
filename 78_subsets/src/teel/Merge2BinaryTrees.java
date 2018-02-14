package teel;

public class Merge2BinaryTrees {
	 public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		 if (t1 == null && t2 == null) {
			 return null;
		 } 
		 TreeNode t;
		 if (t1 == null) {
			 t = new TreeNode(t2.val);
			 t.left = mergeTrees(null, t2.left);
			 t.right = mergeTrees(null, t2.right);
			 return t;
		 } else if (t2 == null) {
			 t = new TreeNode(t1.val);
			 t.left = mergeTrees(t1.left, null);
			 t.right = mergeTrees(t1.right, null);
		 } else {
			 t = new TreeNode(t1.val + t2.val);
			 t.left = mergeTrees(t1.left, t2.left);
			 t.right = mergeTrees(t1.right, t2.right);
		 }
		 return t;
	 }
}
