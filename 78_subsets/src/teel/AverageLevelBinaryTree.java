package teel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AverageLevelBinaryTree {
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ld = new ArrayList<>();
        if (root == null) {
        		return ld;
        } 
        if (root.left == null && root.right == null) {
        	ld.add(Double.valueOf(root.val));
        		return ld;
        }
        List<List<TreeNode>> llt = new ArrayList<>();
        List<TreeNode> q = new ArrayList<TreeNode>();
        q.add(root);
        
        while(!q.isEmpty()) {
        		
        		double sum = 0;
        		int count = 0;
        		List<TreeNode> children = new ArrayList<TreeNode>();
        		
        		while (!q.isEmpty()) {
        			TreeNode popped = q.remove(0);
        			sum += popped.val;
        			count++;
	        		if (popped.left != null) {
	        			children.add(popped.left);
	        		}
	        		if (popped.right != null) {
	        			children.add(popped.right);
	        		}
        		}
        		ld.add(Double.valueOf(sum/count));
        		
        		q = children;
        }
        	return ld;
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
	
	public void inorder(TreeNode node)
	{
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.val + " ");
		inorder(node.right);
 	}
	
	public static void main(String []args)
	{
		int []a = {8,5,3,4,6,10,7};
		TreeNode root = null;
		AverageLevelBinaryTree lot = new AverageLevelBinaryTree();
		for (int i = 0; i < a.length;i++) {
			root = lot.insert(a[i], root);
		}
		lot.inorder(root);
		List<Double> ld = lot.averageOfLevels(root);
		for (Double d : ld) {
			System.out.println(d);
		}
	}
}
