package teel;

public class RotateList {
	/*
	 * Given 1->2->3->4->5->NULL and k = 2,

		return 4->5->1->2->3->NULL.
	 */
	
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;
		ListNode temp = head;
		int count = 0;
		ListNode tail = null;
		while (temp != null) {
			count++;
			tail = temp;
			temp = temp.next;
		}
		k = k % count;
		int jump = count -k;
		temp = head;
		int i = 0;
		while (temp != null && i < jump - 1) {
			i++; temp = temp.next;
		}
		if (temp == null) {
			return head;
		} else {
			ListNode newhead = temp.next;
			if (temp.next != null) {
				temp.next = null;
				tail.next = head;
				head = newhead;
			}
			return head;
		}
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
		RotateList rl = new RotateList();
		rl.addAtHead(5);rl.addAtHead(4);rl.addAtHead(3);rl.addAtHead(2);rl.addAtHead(1);
		rl.printlist(rl.rotateRight(rl.head, 24));
	}
}
