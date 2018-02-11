package teel;

public class AddTwoNumberMSBFirst {
	private ListNode rev(ListNode l)
	{
		ListNode prev = null, curr = l, temp = l;
		while (temp != null) {
			curr = temp;
			temp = temp.next;
			curr.next = prev;
			prev = curr;
		}
		return curr;
	}
	
	ListNode res = null;
	
	private void addToResHead(ListNode newnode)
	{
		if (res != null) {
			newnode.next = res;
			res = newnode;
		} else {
			res = newnode;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		//Reverse the lists
		l1 = rev(l1);
		l2 = rev(l2);
		ListNode tl1 = l1, tl2 = l2;
		int carry = 0, val = 0;
		
		while (tl1 != null && tl2 != null) {
			int sum = 0;
			sum = (tl1.val + tl2.val  + carry)% 10;
			carry = (tl1.val + tl2.val + carry) / 10 ;
			ListNode newnode = new ListNode(sum);
			addToResHead(newnode);
			tl1 = tl1.next;
			tl2 = tl2.next;
		}
		if (tl1 != null && tl2 == null) {
			while (tl1 != null) {
				int sum = (tl1.val   + carry)% 10;
				carry = (tl1.val + carry) / 10 ;
				ListNode newnode = new ListNode(sum);
				addToResHead(newnode);
				tl1 = tl1.next;
			}
		}
		if (tl2 != null && tl1 == null) {
			while (tl2 != null) {
				int sum = ( tl2.val  + carry)% 10;
				carry = (tl2.val + carry) / 10 ;
				ListNode newnode = new ListNode(sum);
				addToResHead(newnode);
				tl2 = tl2.next;
			}
		}
		if (carry != 0) {
			ListNode newnode = new ListNode(carry);
			addToResHead(newnode);
		}
		return res;
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
			System.out.print(l.val);
			l = l.next;
		}
		System.out.println();
	}
	
	public static void main(String []args)
	{
		AddTwoNumberMSBFirst atn = new AddTwoNumberMSBFirst();
		ListNode l1 = null, l2 = null;
		l1 = atn.addToList(l1, 3);
		l1 = atn.addToList(l1, 4);
		l1 = atn.addToList(l1, 2);
		l1 = atn.addToList(l1, 7);
		
		atn.printList(l1);
		l2 = atn.addToList(l2, 4);
		l2 = atn.addToList(l2, 6);
		l2 = atn.addToList(l2, 5);
		atn.printList(l2);
		ListNode l3 = atn.addTwoNumbers(l1, l2);
		atn.printList(l3);
	}
}
