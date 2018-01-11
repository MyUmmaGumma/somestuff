package teel;

public class TreeDiameter {
	public static int maxloop;
	
	public int[] path(TreeNode root) {
		return null;
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 0;
		}
		int l = 0, r = 0;
		if (root.left != null) {
		    l = diameterOfBinaryTree(root.left);
		}
		if (root.right != null) {
			r = diameterOfBinaryTree(root.right);
		}
		return l + r + 1;
    }
}
