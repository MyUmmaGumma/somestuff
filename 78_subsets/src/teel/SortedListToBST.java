package teel;

public class SortedListToBST {
	
	/*public TreeNode createTree(ListNode left, ListNode right)
	{
		ListNode temp = left;
		ListNode temp2 = left;
		ListNode prev = null;
		if (left == null) {
			return null;
		}
		if (left.next == right) {
			TreeNode tn = new TreeNode(left.val);
			tn.right = new TreeNode(right.val);
			return tn;
		}
		
		while (temp != null && temp2 != null && temp2.val <= right.val) {
			prev = temp;
			temp = temp.next;
			if (temp2.next != null && temp2.val <= right.val) {
				temp2 = temp2.next.next;
			} else {
				break; 
			}
		}
		
		TreeNode tn = new TreeNode(temp.val);
		if (left.val < prev.val) {
			tn.left = createTree(left, prev);
		} else {
			tn.left = null;
		}
		if (temp != null) {
			if ( temp.next != null && temp.next.val < right.val) {
				tn.right = createTree(temp.next, right);
			} else {
				tn.right =  new TreeNode(temp.val);
			}
		} else {
			tn.right = null;
		}
		
		return tn;
	}
	
	public TreeNode sortedListToBST(ListNode head) {
		ListNode end = head;
		while (end.next != null) {
			end = end.next;
		}
		return createTree( head, end);
    }*/
	
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) { 
			return null;
		}
		return sortedListToBST_int(head, null);
	}
	
	private TreeNode sortedListToBST_int(ListNode head, ListNode tail)
	{
		ListNode slow = head, fast = head;
		if (head == tail) {
			return null;
		}
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode t = new TreeNode(slow.val);
		t.left = sortedListToBST_int(head, slow);
		t.right = sortedListToBST_int(slow.next, tail);
		return t;
	}
	
	public ListNode addToList(ListNode l, int val)
	{
	
		ListNode l1 = new ListNode(val);
		if (l == null) {
			return l1;
		} else {
			l1.next = l;
			return l1;
		}
	}
	
	public void printList(ListNode l)
	{
		while (l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
		System.out.println();
	}
	
	public void inorder(TreeNode t)
	{
		if (t == null) {
			return;
		} else {
			inorder(t.left);
			System.out.println(t.val);
			inorder(t.right);
		}
	}
	
	public static void main(String []args)
	{
		SortedListToBST atn = new SortedListToBST();
		ListNode l1 = null;
		l1 = atn.addToList(l1, 18);
		l1 = atn.addToList(l1, 14);
		l1 = atn.addToList(l1, 11);
		l1 = atn.addToList(l1, 10);
		l1 = atn.addToList(l1, 8);
		l1 = atn.addToList(l1, 6);
		l1 = atn.addToList(l1, 5);
		l1 = atn.addToList(l1, 2);
		l1 = atn.addToList(l1, 1);
		atn.printList(l1);
		TreeNode t = atn.sortedListToBST(l1);
		atn.inorder(t);
	}
}
