package teel;

public class InvertTree {
	 public TreeNode invertTree(TreeNode root) {
		 if (root == null) {
			 return null;
		 }
		 if (root.left == null && root.right == null) {
			 return root;
		 }
		 TreeNode temp;
		 temp = root.left;
		 root.left = root.right;
		 root.right = temp;
		 invertTree(root.left);
		 invertTree(root.right);
		 return root;
	 }
}
