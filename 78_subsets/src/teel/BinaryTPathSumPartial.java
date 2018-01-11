package teel;

import java.util.ArrayList;
import java.util.List;
/*
 * You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 */

public class BinaryTPathSumPartial {
	private int convertCurrToRes(List<Integer> curr, int sum, List<List<Integer>> res)
	{
      /*  System.out.print("Curr: ");
        for (Integer a1 : curr) {
            System.out.print(a1 + " ");
        }
        System.out.println(""); */
		int cnt = 0;
		for (int i = 0; i < curr.size(); i++ ) {
			int run = 0;
			for (int j = i; j < curr.size(); j++ ) {
				run += curr.get(j);
			}
			if (run == sum) {
				/* Causes TLE!
				 * List<Integer> lnew = new ArrayList<Integer>();
				for(int k = i; k < curr.size(); k++) {
					lnew.add(curr.get(k));
				}
				res.add(lnew); */
				cnt++;
			}
			
		}
		return cnt;
	}
	
	private int exploreTree(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> res)
	{
		curr.add(root.val);
		int s = convertCurrToRes(curr, sum, res);
		if (root.left == null && root.right == null) {
            
			return s;
		} else {
			if (root.left != null) {
				s += exploreTree(root.left, sum, curr, res);
				curr.remove(curr.size()-1);
			}
			if (root.right != null) {
				s += exploreTree(root.right, sum, curr, res);
				curr.remove(curr.size()-1);
			}
		}
		return s;
	}
	
	public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
		List<List<Integer>> lli = new  ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		int s = exploreTree(root, sum, curr, lli);
        /*for (List<Integer> a1 : lli) {
			 for (Integer a2 : a1) {
				 System.out.print(a2 + ",");
			 }
            System.out.println("");
		 }*/
		return s;
		//return lli.size();
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
		int []a = {8,5,3,4,6,10,7,2};
		TreeNode root = null;
		BinaryTPathSumPartial lot = new BinaryTPathSumPartial();
		for (int i = 0; i < a.length;i++) {
			root = lot.insert(a[i], root);
		}
		 int size = lot.pathSum(root,18);
		 System.out.print("Size = " + size);
		
	}
}
