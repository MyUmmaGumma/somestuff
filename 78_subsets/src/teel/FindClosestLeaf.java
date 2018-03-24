package teel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class FindClosestLeaf {
	private void fillParent(TreeNode t, HashMap<TreeNode, TreeNode> parent)
	{
		if (t == null) {
			return;
		}
		if (t.left !=null) {
			parent.put(t.left, t);
			fillParent(t.left, parent);
		}
		if (t.right != null) {
			parent.put(t.right, t);
			fillParent(t.right, parent);
		}
	}
	
	private TreeNode search(TreeNode t, int k) {
		if (t == null) {
			return null;
		} else {
			if (t.val == k) {
				return t;
			}
			
			TreeNode t1 = search(t.left, k);
			if (t1 == null) {
				return search(t.right, k);
			} else {
				return t1;
			}
		}
	}
	
	 public int findClosestLeaf(TreeNode root, int k) {
		 HashMap<TreeNode, TreeNode> parent = new HashMap<>();
		 HashSet<TreeNode> visited = new HashSet<>();
		 LinkedList<TreeNode> q = new LinkedList<>();
		 HashMap<TreeNode, Integer> distance = new HashMap<>();
		 
		 TreeNode troot = root;
		 fillParent(troot, parent);
		 troot = root;
		 troot = search(root, k);
		 if (troot == null) {
			 return -1;
		 }
		 q.add(troot);
		 
		 int dist = Integer.MAX_VALUE, steps = 0,treeval = Integer.MIN_VALUE;
		 
		 while (!q.isEmpty()) {
			 LinkedList<TreeNode> q1 = new LinkedList<>();
			 while (!q.isEmpty()) {
				 TreeNode t = q.poll();
				 steps++;
				 if (visited.contains(t)) {
					 continue;
				 }
				 if (t.left == null && t.right == null) {
					 dist = Math.min(dist, distance.get(t));
					 if (dist ==  distance.get(t)) {
						 treeval = t.val;
					 }
					 
				 } else {
					 if (t.left != null && !visited.contains(t.left)) {
						 q1.add(t.left);
						 distance.put(t.left, steps);
					 } 
					 if (t.right != null && !visited.contains(t.right)) {
						 q1.add(t.right);
						 distance.put(t.right, steps);
					 }
					 if (parent.containsKey(t)) {
						 TreeNode t1 = parent.get(t);
						 if (!visited.contains(t1)) {
							 q1.add(t1);
							 distance.put(t1, steps);
						 }
					 }
					 
					 visited.add(t);
				 }
				 q = q1;
			 }
			
		 }
		 return treeval;
	 }
}
