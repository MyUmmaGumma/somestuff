package teel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LowestCommonAncestor {
	
		static TreeNode root = null;
		
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
		
		
	
		
		public TreeNode str2tree(String s) {
		    if (s == null || s.length() == 0) return null;
		    int firstParen = s.indexOf("(");
		    int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
		    TreeNode cur = new TreeNode(val);
		    if (firstParen == -1) return cur;
		    int start = firstParen, leftParenCount = 0;
		    for (int i=start;i<s.length();i++) {
		        if (s.charAt(i) == '(') leftParenCount++;
		        else if (s.charAt(i) == ')') leftParenCount--;
		        if (leftParenCount == 0 && start == firstParen) {cur.left = str2tree(s.substring(start+1,i)); start = i+1;}
		        else if (leftParenCount == 0) cur.right = str2tree(s.substring(start+1,i));
		    }
		    return cur;
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
		
		public TreeNode findcommon(LinkedList<TreeNode> t1, LinkedList<TreeNode> t2)
		{
			if (t1.isEmpty() || t2.isEmpty()) {
				return null;
			} else {
				TreeNode common = null;
				for (TreeNode t : t1) {
					for (TreeNode tdash : t2) {
						if (t.val == tdash.val) {
							common = t;
						}
					}
				}
				return common;
			}
		}
		
		public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			}
			if (p.val > root.val && q.val > root.val) {
				root = root.right;
			}
			if (p.val < root.val && q.val > root.val || 
					(p.val > root.val && q.val < root.val)) {
				return root;
			}
			return lowestCommonAncestor(root, p, q);
	    }
		
		public static void main(String []args)
		{
			//String str = "4(2(3)(1))(6(5))";
			String str = "1(2)";
			
			LowestCommonAncestor lot = new LowestCommonAncestor();
			for (int i = 0; i < str.length();i++) {
				LowestCommonAncestor.root = lot.str2tree(str);
			}
			lot.inorder(LowestCommonAncestor.root);
		
			
		}

}
