package teel;

import java.util.Arrays;
import java.util.LinkedList;

public class SymmetricTree {
	private boolean isQPalindrome(LinkedList<TreeNode> q)
	{
		TreeNode []t = (TreeNode [])q.toArray();
		for (int i = 0; i < t.length; i++) {
			if (t!=null) {
				System.out.println(t[i].val);
			}
		}
		int s = 0, e= t.length;
		while (s < e) {
			
			if ((t[s] == null && t[e] != null) ||
					(t[s] != null && t[e] == null) ||
					(t[s] != null && t[e] != null && t[s].val != t[e].val)) {
				return false;
			}
			s++;e--;
		}
		return true;
	}
	
	public boolean isSymmetric(TreeNode root) {
		LinkedList<TreeNode> q = new LinkedList<>();
		if (root == null) return true;
		q.add(root);
		while (!q.isEmpty()) {
			LinkedList<TreeNode> q1 = new LinkedList<>();
			while (!q.isEmpty()) {
				TreeNode t = q.poll();
                if (t != null) {
				    q.add(t.left);
				    q.add(t.right);
                }
			}
			q = q1;
            if (!q.isEmpty()) {
                if (!isQPalindrome(q)) {
                    return false;
                }
            }
		}
		return true;
    }
}
