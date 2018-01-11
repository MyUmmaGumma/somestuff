package teel;

import java.util.LinkedList;
import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> ls;
 	public BSTIterator(TreeNode root) {
 		ls = new Stack<TreeNode>();
        TreeNode t = root;
        while(t != null) {
        	ls.push(t);
        	t = t.left;
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
	

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !ls.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	
        TreeNode t = ls.peek();
        TreeNode t1 = t;
        ls.pop();
        if (t.right != null) {
        	t = t.right;
        	while(t != null) {
             	ls.push(t);
             	t = t.left;
            }
        }
        return t1.val;
    }
    
    public static void main(String []args)
	{
		int []a = {8,5,3,4,6,10,7};
		TreeNode root = null;
		BSTIterator lot = new BSTIterator(root);
		for (int i = 0; i < a.length;i++) {
			root = lot.insert(a[i], root);
		}
		BSTIterator lot1 = new BSTIterator(root);
		while (lot1.hasNext()) {
			System.out.println("next: " + lot1.next());
		}
	}
}
