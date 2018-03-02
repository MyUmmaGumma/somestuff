package teel;

public class GreaterThanTree {
	private int postorder(TreeNode root, int num)
	{
		if (root == null) {
			return 0;
		} else {
			int r = postorder(root.right, num);
			root.val += r + num;
			int l = postorder(root.left, root.val);
			return root.val- num + l;
		}
	}
	 public TreeNode convertBST(TreeNode root) {
		 postorder(root, 0);
		 return root;
	 }
}
