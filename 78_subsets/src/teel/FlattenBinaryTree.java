package teel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlattenBinaryTree {
	public void preorder(TreeNode root, List<TreeNode> tn)
	{
		if (root == null) {
			return;
		}
		preorder(root.left, tn);
		preorder(root.right, tn);
		if (root.left != null) {
			TreeNode orig = root;
			TreeNode rsubtree = root.right;
			root.right = root.left;
			root.left = null;
			TreeNode prev = null;
			while (root != null) {
				prev = root;
				root = root.right;
			}
			prev.right = rsubtree;
			root = orig;
		}
	}
	
	 public void flatten(TreeNode root) {
		 if (root == null) {
			 return;
		 } 
		 List<TreeNode> l = new ArrayList<TreeNode>();
		 preorder(root, l);
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
			FlattenBinaryTree lot = new FlattenBinaryTree();
			for (int i = 0; i < a.length;i++) {
				root = lot.insert(a[i], root);
			}
			 lot.flatten(root);
			 
		}
}
