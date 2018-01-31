package teel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderReverse {
	 public List<List<Integer>> levelOrderBottom(TreeNode root) {
		 List<List<Integer>> lli = new ArrayList<List<Integer>>();
		 Queue<TreeNode> q = new LinkedList<>();
		 q.add(root);
		 while (!q.isEmpty()) {
			 
			 List<Integer> li = new ArrayList<>();
			 Queue<TreeNode> children = new LinkedList<>();
			 while (!q.isEmpty()) {
				 TreeNode popped = q.poll();
				 li.add(popped.val);
				 if (popped.left != null) {
					 children.add(popped.left);
				 }
				 if (popped.right != null) {
					 children.add(popped.right);
				 }
			 }
			 lli.add(0, li);
			 q = children;
		 }
		 return lli;
	 }
	 
	 private TreeNode newTreeNode(int num)
		{
			TreeNode newnode = new TreeNode(num);
			newnode.left = newnode.right = null;
			return newnode;
		}
		
		private TreeNode insert(int num, TreeNode root)
		{
			TreeNode newNode = newTreeNode(num);
			if (root == null) {
				root = newNode;
				return root;
			}
			if (root.val < num) {
				root.right = insert(num, root.right);
			} else {
				root.left = insert(num, root.left);
			}
			return root;
		}
		
		
		public static void main(String []args)
		{
			int []a = {8,5,3,4,6,10,7};
			TreeNode root = null;
			LevelOrderReverse lot = new LevelOrderReverse();
			for (int i = 0; i < a.length;i++) {
				root = lot.insert(a[i], root);
			}	
			List<List<Integer>> lli = lot.levelOrderBottom(root);
			for (List<Integer> li : lli) {
				for (Integer i : li) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
}
