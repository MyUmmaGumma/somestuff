package teel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CountCompleteTreeNodes {
	
	public int levelOrderTraversal(LinkedList<TreeNode> ll, int curr)
	{
		List<List<Integer>> lli = new ArrayList<List<Integer>>();
		int cnt = curr;
		while(!ll.isEmpty()) {	
			TreeNode tn = ll.removeFirst();
			if (tn.left != null) {
				cnt += 1;
				ll.add(tn.left);
			} else {
				return cnt;
			}
			if (tn.right != null) {
				cnt += 1;
				ll.add(tn.right);
			} else {
				return cnt;
			}
		}
		return cnt;
	}
	
	public int countNodes(TreeNode root) {
		LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
		if (root == null) {
			return 0;
		}
		ll.add(root);
		return levelOrderTraversal(ll, 0);
    }
	
	
	public int levelOrder(TreeNode root) {
		LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
		if (root == null) {
			return 0;
		}
		ll.add(root);
		return levelOrderTraversal(ll, 0);
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
		CountCompleteTreeNodes lot = new CountCompleteTreeNodes();
		for (int i = 0; i < a.length;i++) {
			root = lot.insert(a[i], root);
		}
		lot.inorder(root);
		System.out.println("Level order traversal follows");
		int c = lot.levelOrder(root);
		System.out.println(c);
	}
}
