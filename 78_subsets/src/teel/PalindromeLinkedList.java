package teel;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		//Get to the middle of the list
		ListNode one = head, two= head; ListNode prev1 = null;
		if (head == null || head.next == null) return true;
		while (two != null && two.next != null) {
			prev1 = one;
			one = one.next;
			two = two.next.next;
		}
		if (prev1 != null) {
			prev1.next = null;
		}
		//now reverse from middle of list
		ListNode temp = one, curr = one, prev = null;
		while(temp != null) {
			curr = temp.next;
			temp.next = prev;
			prev = temp;
			temp = curr;
		}
		ListNode reversed_head = prev;
		temp = reversed_head; curr = head;
		if (temp == curr.next) {
			if (temp.val == curr.val) {
				return true;
			} else {
				return false;
			}
		}
		//Compare reversed vs original
		while (temp != curr) {
			if ((temp == null && curr == null) || (temp.next == null && curr == null )) return true;
			if (temp.val != curr.val) {
				return false;
			}
			temp = temp.next;
			curr = curr.next;
		}
		return true;
    }
	
	ListNode head;
	 void addAtHead(int val)
	{
		ListNode t = new ListNode(val);
		t.next = head;
		head = t;
		
	}
	
	void printlist(ListNode t)
	{

			while(t != null) {
				System.out.print(t.val + " " );
				t = t.next;
			}
			System.out.println();
		
	}
	
	public static void main(String []args)
	{
		PalindromeLinkedList rl = new PalindromeLinkedList();
		rl.addAtHead(12);rl.addAtHead(0);rl.addAtHead(12);
		rl.printlist(rl.head);
		System.out.println(rl.isPalindrome(rl.head));
	}
}
