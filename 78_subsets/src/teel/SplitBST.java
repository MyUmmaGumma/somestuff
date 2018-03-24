package teel;

public class SplitBST {
	
	private TreeNode insert(TreeNode root, int v)
	{
		if (root == null) {
			return new TreeNode(v);
		}
		if (root.val < v) {
			root.right = insert(root.right, v);
		} else {
			root.left = insert(root.left, v);
		}
		return root;
	}
	
	 private void traverse(TreeNode root, int v, TreeNode []roots)
	 {
		 if (root == null) {
			 return;
		 }
		 if (root.val <= v) {
			 roots[0] = insert(roots[0], root.val);
		 } else {
			 roots[1] = insert(roots[1], root.val);
		 }
		 traverse(root.left, v, roots);
		 traverse(root.right, v, roots);
	 }
	
	  public TreeNode[] splitBST(TreeNode root, int V) {
		TreeNode []ret = new TreeNode[2];
		traverse(root, V, ret);
		return ret;
	  }
}
