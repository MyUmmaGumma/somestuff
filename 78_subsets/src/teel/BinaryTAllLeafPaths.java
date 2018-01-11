package teel;

import java.util.ArrayList;
import java.util.List;

public class BinaryTAllLeafPaths {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	private void convertCurrToRes(List<Integer> curr, List<String> res)
	{
		StringBuilder str = new StringBuilder();
		for (Integer i : curr) {
			if (str.length() > 0) {
				str.append("->");
			}
			str.append(i.toString());
		}
		res.add(str.toString());
	}
	
	private void exploreTree(TreeNode root, List<Integer> curr, List<String> res)
	{
		curr.add(root.val);
		if (root.left == null && root.right == null) {
			convertCurrToRes(curr, res);
			return;
		} else {
			if (root.left != null) {
				exploreTree(root.left, curr, res);
				curr.remove(curr.size()-1);
			}
			if (root.right != null) {
				exploreTree(root.right, curr, res);
				curr.remove(curr.size()-1);
			}
		}
	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root == null) {
			return res;
		}
		List<Integer> current = new ArrayList<Integer>();
		exploreTree(root, current, res);
		return res;
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
		BinaryTAllLeafPaths lot = new BinaryTAllLeafPaths();
		for (int i = 0; i < a.length;i++) {
			root = lot.insert(a[i], root);
		}
		 List<String> ls = lot.binaryTreePaths(root);
		 for (String a1 : ls) {
			 System.out.println(a1 + ",");
		 }
	}
}
