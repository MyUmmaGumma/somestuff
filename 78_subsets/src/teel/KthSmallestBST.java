package teel;

import java.util.LinkedList;
import java.util.List;

public class KthSmallestBST {
	 private int kthSmallest_int(TreeNode root, int k, List <Integer> vals) {
		 if (root == null) {
			 return Integer.MAX_VALUE;
		 } else {
			 	if (root.left == null && root.right == null) {
			 		vals.add(root.val);
			 		if (k == vals.size()) {
			 			return vals.size();
			 		} else {
			 			return Integer.MAX_VALUE;
			 		}
				}
			 }
			 int x = kthSmallest_int(root.left, k, vals);
			 if (x != Integer.MAX_VALUE) {
				 return x;
			 }
			 vals.add(root.val);
			 if (k == vals.size()) {
				 return root.val;
			 }
			 int y = kthSmallest_int(root.right, k, vals);
			 if (y != Integer.MAX_VALUE) {
				 return y;
			 }
	return Integer.MAX_VALUE;
	 }
	 public int kthSmallest(TreeNode root, int k) {
		  List<Integer> li = new LinkedList<Integer>();
	      return kthSmallest_int(root, k, li);
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
			KthSmallestBST lot = new KthSmallestBST();
			for (int i = 0; i < a.length;i++) {
				root = lot.insert(a[i], root);
			}
			 int i = lot.kthSmallest(root,3);
			 System.out.println(i);
		}
}
