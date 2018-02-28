package teel;

import java.util.HashMap;

public class HouseRobber3 {
	
	private int rob_int(TreeNode root, boolean parentRobbed, HashMap<TreeNode, Integer> hm)
	{
		if (root == null) {
			return 0;
		} 
		int leftval= 0, rightval = 0, wparent = 0, woparent = 0;
		if (parentRobbed) {
			if (hm.containsKey(root.left)) {
				leftval = hm.get(root.left);
			} else {
				leftval = rob_int(root.left, false, hm);
				hm.put(root.left, leftval);
			}
			if (hm.containsKey(root.right)) {
				rightval = hm.get(root.right);
			} else {
				rightval = rob_int(root.right, false, hm);
				hm.put(root.right, rightval);
			}
			wparent = leftval + rightval;
		} else {
			leftval = (root.left == null) ? 0 : Math.max(rob_int(root.left, true, hm) + root.left.val,
					rob_int(root.left, false, hm));	
			rightval = (root.right == null) ? 0 : Math.max(rob_int(root.right, true,hm) + root.right.val,
					rob_int(root.right, false, hm));
			woparent = leftval + rightval;
		}
		return Math.max(woparent, wparent);
	}
	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		HashMap<TreeNode, Integer> hm = new HashMap<>();
	    return Math.max(rob_int(root, false, hm), rob_int(root, true, hm) + root.val);
	}
}
