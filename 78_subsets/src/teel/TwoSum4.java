package teel;

import java.util.HashSet;
import java.util.Set;

public class TwoSum4 {
	private boolean find_int(TreeNode root, Set<Integer> s, int k)
	{
		if (s.contains(k- root.val) == true) {
			return true;
		}
		if (root.left != null) {
			boolean res = find_int(root.left, s, k);
			if (res == true) {
				return true;
			}
		}
		if (root.right != null) {
			boolean res = find_int(root.right, s, k);
			if (res == true) {
				return true;
			}
		}
		return false;
	}
	
	public boolean findTarget(TreeNode root, int k) {
		Set<Integer> s = new HashSet<>();
		if (root == null) {return false;}
		return find_int(root, s, k);
    }
}
