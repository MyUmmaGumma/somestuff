package teel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KthSmallestBST {
	 private void kthSmallest_int(TreeNode root, int k, List <Integer> vals) {
		 if (k == vals.size() || root == null) {
			 return;
		 } else {
			 kthSmallest_int(root.left, k, vals);
			 if (k > vals.size()) {
				 vals.add(root.val);
			 } else {
				 return;
			 }
			 if (k == vals.size()) {
				 return;
			 }
			 kthSmallest_int(root.right, k, vals);
		 }
	 }
	 
	 public int kthSmallest(TreeNode root, int k) {
		  List<Integer> li = new ArrayList<Integer>();
	      kthSmallest_int(root, k, li);
	      return li.remove(li.size()-1);
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
			 int i = lot.kthSmallest(root,1);
			 System.out.println(i);
		}
}
