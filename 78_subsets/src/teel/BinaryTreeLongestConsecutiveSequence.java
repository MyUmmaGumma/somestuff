package teel;

public class BinaryTreeLongestConsecutiveSequence {
	public int lc_int(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 1;
		}
		int lcl = -1, lcr = -1;
		if (root.left != null) {
			lcl = lc_int(root.left);
		} else {
			lcr = lc_int(root.right) + 1;
		}
		return Math.max(lcl, lcr);
    }
	
	public int longestConsecutive(TreeNode root) {
        if (root == null) {
        		return 0;
        }
        return 0;
    }
}
