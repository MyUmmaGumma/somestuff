package teel;

public class Merge2SortedLists {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode dummy = new ListNode(0);
			ListNode ln = dummy;
			if (l1 == null) {
				return l2;
			}
			if (l2 == null) {
				return l1;
			}
			while (l1 != null || l2 != null) {
				
				int l1val = (l1 == null) ? Integer.MAX_VALUE : l1.val;
				int l2val = (l2 == null) ? Integer.MAX_VALUE : l2.val;
				
				if (l1val < l2val) {
					ln.next = l1;
					l1 = l1.next;
				} else {
					ln.next = l2;
					l2 = l2.next;
				}
				ln = ln.next;
			}
			return dummy.next;
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
	
	public static void main(String []args) {
		Merge2SortedLists msl = new Merge2SortedLists();
		ListNode l1 = null;
		ListNode l2 = null;
		l1 = msl.addToList(l1, 9);
		l2 = msl.addToList(l2, 8);
		l1 = msl.addToList(l1, 6);
		l2 = msl.addToList(l2, 5);
		l1 = msl.addToList(l1, 3);
		l2 = msl.addToList(l2, 4);
		l1 = msl.addToList(l1, 1);
		l2 = msl.addToList(l2, 2);
		l2 = msl.addToList(l2, -1);
		l2 = msl.addToList(l2, -2);
		msl.printList(l1);
		msl.printList(l2);
		ListNode l3 = msl.mergeTwoLists(l1, l2);
		msl.printList(l3);
	}
}
