package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeBoundary {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
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
    }
}
