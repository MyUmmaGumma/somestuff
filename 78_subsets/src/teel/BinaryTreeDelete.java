package teel;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeDelete {
	Map<TreeNode, TreeNode> parent = new HashMap<>();
	
	private TreeNode search(TreeNode root, int key)
	{
		if (root.val == key) {
			return root;
		}
		TreeNode found = null;
		if (key < root.val) {
			found = search(root.left, key);
		} else if (key > root.val) {
			found = search(root.right, key);
		} 
		return found;
	}
	
	private void createParents(TreeNode root, TreeNode p)
	{
		parent.put(root, p);
		if (root.left != null) {
			parent.put(root.left, root);
		}
		if (root.right != null) {
			parent.put(root.right, root);
		}
	}
	
	//CLR - replace u with v
	private void transplant(TreeNode u, TreeNode v, TreeNode root)
	{
		TreeNode pu = (parent.containsKey(u) == false) ? null : parent.get(u);
		TreeNode pv = (parent.containsKey(v) == false) ? null : parent.get(v);
		if (pu == null) {
			root = v;
		} else {
			if (u == pu.left) {
				pu.left = v;
			} else if ( u == pu.right) {
				pu.right = v;
			} else {
				pu.left = v; pu.right = v;
			}
		}
		if (pv != null) {
			parent.put(v, pu);
		}
	}
	
	private TreeNode tminimum(TreeNode t)
	{
		if (t.right != null) {
			t = t.right;
			while (t.left != null) {
				t = t.left;
			}
			return t;
		}
		return null;
	}
	
	/*public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
        createParents(root, null);
        TreeNode t = root;
        TreeNode z = search(t, key);
        if (z != null) {
        		TreeNode pz = (parent.containsKey(z) == false) ? null : parent.get(z);
        		if (z.right == null && z.left == null) {
        			z = null;
        		} else if (z.left == null) {
        			transplant(z, z.right, root);
        		} else if (z.right == null) {
        			transplant(z, z.left, root);
        		} else {
        			TreeNode y = tminimum(z);
        			//wont check for y is null
        			TreeNode py = (parent.containsKey(y) == false) ? null : parent.get(y);
        			if (py != z) {
        				transplant(y, y.right, root);
        				y.right = z.right;
        				
        			}
        			transplant(z, y, root);
        			y.left = z.left;
        			TreeNode pzleft = (parent.containsKey(z.left) == false) ? null : parent.get(z.left);
        			parent.put(pzleft, y);
        		}
        }
        return root;
    }*/
	//https://leetcode.com/problems/delete-node-in-a-bst/discuss/93378/an-easy-understanding-oh-time-o1-space-java-solution
	private TreeNode deleteNode_int(TreeNode root)
	{
		if (root == null) return null;
		if (root.right == null) return root.left;
		TreeNode x = root.right;
		while (x.left !=null) 
			x= x.left;
		x.left = root.left;
		return root.right;
	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root ==null || key == root.val) {
			return deleteNode_int(root);
		}
		TreeNode p = root;
		while (true) {
			if (p.val < key) {
				if (p.right == null || p.right.val == key) {
					p.right = deleteNode_int(p.right);
					break;
				}
				p = p.right;
			} else {
				if (p.left == null || p.left.val == key) {
					p.left = deleteNode_int(p.left);
					break;
				}
				p = p.left;
			}
		}
		return root;
	}
	
}
