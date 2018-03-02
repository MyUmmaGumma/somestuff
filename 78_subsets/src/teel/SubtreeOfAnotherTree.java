package teel;

public class SubtreeOfAnotherTree {
	
	 
	private boolean exactEquals(TreeNode s, TreeNode t)
	{
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		
		if ((s.val == t.val) && exactEquals(s.left, t.left)  && exactEquals(s.right, t.right)) {
			return true;
		}
		return false;
	}
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val == t.val && exactEquals(s,t)) {
			return true;
		}
		if (isSubtree(s.left, t) || isSubtree(s.right, t)) {
			return true;
		}
		return false;
    }
}
