package teel;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {
	 private void inorder_walk(TreeNode root,List<TreeNode> valid)
	    {
	        if (root == null) {
	            return;
	        }
	        inorder_walk(root.left, valid);
	        valid.add(root);
	        inorder_walk(root.right, valid);
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
		
	    
	    public boolean isValidBST(TreeNode root) {
	        List<TreeNode> valid= new ArrayList<>();
	        inorder_walk(root,  valid);
	        TreeNode prev = null;
	        for (TreeNode curr : valid) {
	            if (prev == null) {
	                prev = curr;
	                continue;
	            }
	            System.out.println("Prev: " + prev.val + " Curr: " + curr.val);
	            if (prev.val >= curr.val)
	                return false;
	            prev = curr;
	        }
	        return true;
	   }
	    
	    public static void main(String []args)
	    {
	    		int []a = {8,5,3,4,6,10,7};
			TreeNode root = null;
			ValidBST lot = new ValidBST();
			for (int i = 0; i < a.length;i++) {
				root = lot.insert(a[i], root);
			}
			System.out.println(lot.isValidBST(root));
	    }
}
