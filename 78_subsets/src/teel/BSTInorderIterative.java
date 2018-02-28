package teel;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class BSTInorderIterative {
	  public List<Integer> inorderTraversal(TreeNode root) {
		  List<TreeNode> ls = new ArrayList<>();
		  List<Integer> ret = new ArrayList<>();
		  do {
			  pushAllLeftNodes(ls ,root);
			  if (!ls.isEmpty()) {
				  TreeNode curr = ls.remove(ls.size()-1);
				  ret.add(curr.val);
				  root = curr.right;
			  }
		  } while (root != null || !ls.isEmpty());
		  return ret;
	  }
	  
	  void pushAllLeftNodes(List<TreeNode> ls, TreeNode start)
	  {
		  while (start != null) {
			  ls.add(start);
			  start = start.left;
		  }
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
			BSTInorderIterative lot = new BSTInorderIterative();
			for (int i = 0; i < a.length;i++) {
				root = lot.insert(a[i], root);
			}
			List<Integer> ls = lot.inorderTraversal(root);
			for (int i : ls) {
				System.out.print(i + " ");
			}
	    }
}
