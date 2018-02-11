package teel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LargestTreeRow {
	 public List<Integer> largestValues(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        List<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
        		int largest = Integer.MIN_VALUE;
        		List<TreeNode> children = new LinkedList<>();
        		while (!q.isEmpty()) {
        			TreeNode t = q.remove(0);
	        		if (t.left != null) children.add(t.left);
        			if (t.right != null) children.add(t.right);
        			if (largest < t.val) {
        				largest = t.val;
        			}
        		}
    			li.add(largest);
    			q = children;
        }
        return li;
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
			LargestTreeRow lot = new LargestTreeRow();
			for (int i = 0; i < a.length;i++) {
				root = lot.insert(a[i], root);
			}
			 List<Integer> li = lot.largestValues(root);
			 for (Integer a1 : li) {
				 System.out.print(a1 + ",");
				
			 }
		}
	 
}
