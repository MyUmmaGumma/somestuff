package teel;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class LevelOrderTraversal {
	private  List<List<Integer>> levelOrderTraversal(TreeNode root, LinkedList<TreeNode> ll) {
		
		List<List<Integer>> lli = new ArrayList<List<Integer>>();
		boolean zig = true;
		while(!ll.isEmpty()) {
			List<Integer> li = new ArrayList<Integer>();
			int size = ll.size();
			if (zig) {
				for (int i = 0; i < size; i++) {
					TreeNode tn = ll.remove();
					li.add(tn.val);
					if (tn.left != null) {
						ll.add(tn.left);
					}
					if (tn.right != null) {
						ll.add(tn.right);
					}
				}
				zig = false;
			} else {
				ArrayList<Integer> a = new ArrayList<Integer>();
				for (int i = 0; i < size; i++) {
					TreeNode tn = ll.remove();
					a.add(tn.val);
					if (tn.left != null) {
						ll.add(tn.left);
					}
					if (tn.right != null) {
						ll.add(tn.right);
					}
				}
				zig = true;
				Collections.reverse(a);
				for (int i = 0; i < a.size(); i++) {
					li.add(a.get(i));
				}
			}
			lli.add(li);
		}
		
		
		return lli;
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
		if (root == null) {
			return new ArrayList<List<Integer>>();
		}
		ll.add(root);
		return levelOrderTraversal(root, ll);
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
		LevelOrderTraversal lot = new LevelOrderTraversal();
		for (int i = 0; i < a.length;i++) {
			root = lot.insert(a[i], root);
		}
		lot.inorder(root);
		System.out.println("Level order traversal follows");
		List<List<Integer>> lli = lot.levelOrder(root);
		for (List<Integer> li : lli) {
			for (Integer i : li) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
