package teel;

import java.util.LinkedList;

import teel.NextRightPointer.TreeLinkNode;

public class NextRightPointerAnyTree {
	
	public TreeLinkNode root;
	
	class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
	  }
	
	  private TreeLinkNode newNode(int val)
	    {
	    	TreeLinkNode t = new TreeLinkNode(val);
	    	t.left = t.next = t.right = null;
	    	return t;
	    }
	  
	public void populate(int []arr)
    {
    	LinkedList<TreeLinkNode> ls1 = new LinkedList<TreeLinkNode>();
    	for (int i = 0; i < arr.length; ) {
    		TreeLinkNode t1 = newNode(arr[i]);
    		if (root == null) {
    			root = t1;
    			ls1.add(t1);
    			i += 1;
    		} else {
    			TreeLinkNode t = ls1.remove();
    			if (t == null) {
    				continue;
    			}
    			if (arr[i] == -1) {
    				t.left = null;
    			} else {
    				t.left = newNode(arr[i]);
    			}
    			if (arr[i+1] == -1) {
    				t.right = null;
    			} else {
    				t.right = newNode(arr[i+1]);
    			}
    			
    			ls1.add(t.left);
    			ls1.add(t.right);
    			i += 2;
    		}
    	}	
    }
	
	 public void connect(TreeLinkNode root) 
	 {
		 TreeLinkNode dummy = new TreeLinkNode(0);
		 TreeLinkNode prev = dummy;
		 while (root != null) {
			 if (root.left != null) {
				 prev.next = root.left;
				 prev = dummy.next;
			 }
			 if (root.right != null) {
				 prev.next = root.right;
				 prev = dummy.next;
			 }
			 root = root.next;
			 
			 if (root == null) {
				 prev = dummy;
				 root= dummy.next;
				 dummy.next = null;
			 }
		 }
	 }
    
    public static void main(String []args)
    {
    	//int []arr = {2,-1,3,-1,4,-1,5,-1,6};
    	int []arr = {1,2};
    	NextRightPointerAnyTree nrp = new NextRightPointerAnyTree();
    	nrp.populate(arr);
    	
    	nrp.connect(nrp.root);
    	
    }
}
