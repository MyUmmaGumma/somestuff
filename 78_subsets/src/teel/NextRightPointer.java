package teel;

import java.util.LinkedList;

/*  Definition for binary tree with next pointer. */

  
 
public class NextRightPointer {
	class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
	  }
	LinkedList<TreeLinkNode> ls = new LinkedList<TreeLinkNode>();
	public TreeLinkNode root;
	
    public void connect(TreeLinkNode root) 
    {
    	if (root == null) return;
    	ls.add(root);
    	int count = 0, iter = 1;
    	TreeLinkNode prev = null;
    	while (!ls.isEmpty()) {
    		TreeLinkNode t = ls.remove();
    		if (t == null) {
    			if (ls.isEmpty()) {
    				break;
    			}
    			ls.add(null);
    			ls.add(null);
    			count++;
    			continue;
    		}
    		if (t.left != null || t.right != null) {
    			ls.add((t.left == null) ? null : t.left);
    			ls.add((t.right == null) ? null : t.right);
    		}
    		count++;
    		if (count == ((iter*2) - 1)) {
    			iter = iter*2;
    			if (prev != null) {
    				prev.next = t;
    			}
    			t.next = null;
    			prev = null;
    		} else {
    			if (!ls.isEmpty()) {
    				if (ls.getFirst() != null) {
	    				if (prev != null) {
	    					prev.next = t;
	    					prev = t;
	    				} else {
	    					t.next = ls.getFirst();
	    				}
    				}
    				else { 
    					prev = t;
    				}
    			}
    		}
    	}
    }
    
    private TreeLinkNode newNode(int val)
    {
    	TreeLinkNode t = new TreeLinkNode(val);
    	t.left = t.next = t.right = null;
    	return t;
    }
    
    public void preorder(TreeLinkNode t)
    {
    	if (t == null) {
    		return;
    	}
    	
    	System.out.println(t.val);
    	preorder(t.left);
    	preorder(t.right);
    }
    
    public void preorderPrintRoot(TreeLinkNode t)
    {
    	if (t == null) {
    		return;
    	}
    	if (t.next == null) {
    		System.out.println(t.val + " ->  NULL");
    	} else {
    		System.out.print(" -> "+ t.val + " -> "+  t.next.val);
    	}
    	preorderPrintRoot(t.left);
    	preorderPrintRoot(t.right);
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
    
    public static void main(String []args)
    {
    	//int []arr = {2,-1,3,-1,4,-1,5,-1,6};
    	int []arr = {1,2};
    	NextRightPointer nrp = new NextRightPointer();
    	nrp.populate(arr);
    	nrp.preorder(nrp.root);
    	nrp.connect(nrp.root);
    	nrp.preorderPrintRoot(nrp.root);
    }
}