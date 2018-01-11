package teel;

import java.util.ArrayList;
import java.util.List;

public class BinaryTPathSum {
	
	private void convertCurrToRes(List<Integer> curr, int sum, List<List<Integer>> res)
	{
		int r = 0;
		for (Integer i : curr) {
			r += i.intValue();			
		}
		System.out.println("Comparing " + r + " sum = " + sum);
		if (sum == r) {
			List<Integer> lnew = new ArrayList<Integer>();
			lnew.addAll(curr);
			res.add(lnew);
		}
	}
	
	private void exploreTree(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res)
	{
		curr.add(root.val);
		if (root.left == null && root.right == null) {
			convertCurrToRes(curr, sum, res);
			return;
		} else {
			if (root.left != null) {
				exploreTree(root.left, sum, curr, res);
				curr.remove(curr.size()-1);
			}
			if (root.right != null) {
				exploreTree(root.right, sum, curr, res);
				curr.remove(curr.size()-1);
			}
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> lli = new  ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		exploreTree(root, sum, curr, lli);
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
		BinaryTPathSum lot = new BinaryTPathSum();
		for (int i = 0; i < a.length;i++) {
			root = lot.insert(a[i], root);
		}
		 List<List<Integer>> lli = lot.pathSum(root,20);
		 for (List<Integer> a1 : lli) {
			 for (Integer a2 : a1) {
				 System.out.print(a2 + ",");
			 }
		 }
	}
}
