package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeBoundary {
	/*public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<TreeNode> q = new LinkedList<TreeNode>();
		List<TreeNode> leaves = new LinkedList<TreeNode>();
		List<Integer> li = new ArrayList<Integer>();
		
		if (root == null) {
			return li;
		}
		q.add(root);
		li.add(root.val);
		List<List<TreeNode>> llt = new LinkedList<List<TreeNode>>();
		
		while(!q.isEmpty()) {
			List<TreeNode> newq = new LinkedList<TreeNode>();
			
			while (!q.isEmpty()) {
				TreeNode node = q.remove(0);
				if (node.left != null) {
					newq.add(node.left);
				}
				if (node.right != null) {
					newq.add(node.right);
			 	}
			}
			if (newq.size() == 0) {
				break;
			}
			llt.add(newq);
			q = new LinkedList<>(newq);
		}
		if (llt.size() == 0) {
			return li;
		}
		for (List<TreeNode> list : llt) {
			li.add(list.get(0).val);
		}
		List<TreeNode>list = llt.get(llt.size()-1);
		for (int i = 1; i < list.size(); i++) {
			li.add(list.get(i).val);
		}
		if (llt.size() > 2) {
			for (int i = llt.size()-2; i >= 0; i--) {
				List<TreeNode> l = llt.get(i);
				li.add(l.get(l.size()-1).val);
			}
		}
		return li;
    }*/
	
	public boolean isLeaf(TreeNode t)
	{
		if (t.left == null &&  t.right == null) {
			return true;
		}
		return false;
	}
	
	public void addLeaves(List<Integer> res , TreeNode t)
	{
		
		if (isLeaf(t)) {
			res.add(t.val);
			return;
		}
		if (t.left != null) {
			addLeaves(res, t.left);
		}
		if (t.right != null) {
			addLeaves(res, t.right);
		}
	}
	
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		
		if (root == null) {
			return res;
		}
		
		// Need to add root if not leaf - addLeaves will add root
		if (!isLeaf(root)) {
			res.add(root.val);
		}
		
		TreeNode t = root.left;
		//Left boundary
		while (t != null) {
			if (isLeaf(t) == false) {
				res.add(t.val);
			}
			if (t.left != null) {
				t  = t.left;
			} else {
				t = t.right;
			}
		}
		
		t = root;
		//All leaves
		addLeaves(res, t); 
		
		t = root.right;
		//Right boundary - add leaves in reverse order so use stack
		Stack<Integer> stk = new Stack<>();
		while (t != null) {
			if (isLeaf(t) == false) {
				stk.push(t.val);
			} 
			if (t.right != null) {
				t  = t.right;
			} else {
				t = t.left;
			}
		}
		while (!stk.isEmpty()) {
			res.add(stk.pop());
		}
		return res;
	}
}
