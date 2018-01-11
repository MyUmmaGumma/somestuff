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
		
		
		private boolean searchInt(TreeNode t, int num, LinkedList<TreeNode> ls)
		{
			/*
			if (t == null) {
				return null;
			} else if (t.val == num) {
				ls.add(t);
				return t;
			} else {
				ls.add(t);
				if (searchInt(t.left, num, ls) != null) {
					return t.left;
				}	
				if (searchInt(t.right, num, ls) != null) {
					return t.right;
				}
				ls.removeLast();
				return null;
			} */
				return false;
		}
		
		LinkedList<TreeNode> search(int num)
		{
			LinkedList<TreeNode> path1 = new LinkedList<TreeNode>();
			LinkedList<TreeNode> path2 = new LinkedList<TreeNode>();
			//n.add(root);
			/*
			searchInt(root, num, path1, path2);
			System.out.println("-----Path-----");
			for (TreeNode t : n) {
				System.out.println(t.val);
			}
			return n; */
			return null;
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
	        if (p == null || root == null || q == null) {
	        	return null;
	        }
	        LinkedList<TreeNode> t1 = search(p.val);
			LinkedList<TreeNode> t2 = search(q.val);
			return findcommon(t1, t2);
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
			LinkedList<TreeNode> t1 = lot.search(2);
			LinkedList<TreeNode> t2 = lot.search(1);
			System.out.println("The common node is " + (lot.findcommon(t1, t2)).val);
		}

}
