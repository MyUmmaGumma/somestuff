package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<Integer> res = new ArrayList<Integer>();
		List<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while (!queue.isEmpty()) {
			List<TreeNode> level = new LinkedList<TreeNode>();
			res.add(queue.get(queue.size()-1).val);
			while (!queue.isEmpty()) {
				TreeNode t = queue.remove(0);
				if (t.left != null) {
					level.add(t.left);
				} 
				if (t.right != null) {
					level.add(t.right);
				}
			}
			
			queue = level;
		}
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
			RightSideView lot = new RightSideView();
			for (int i = 0; i < a.length;i++) {
				root = lot.insert(a[i], root);
			}
			 List<Integer> li = lot.rightSideView(root);
			 for (Integer a1 : li) {
				 System.out.print(a1 + ",");
				
			 }
		}
}
