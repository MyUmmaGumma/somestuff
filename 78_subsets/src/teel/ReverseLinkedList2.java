package teel;
/*
 * For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.
 */
public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode temp = head, curr = head, prev = null;
		if (head == null || m==n) {
			return head;
		}
		int iter = 1;
		while (temp != null && iter < m) {
			prev = temp;
			temp= temp.next;
			iter++;
		}
		if (temp == null) {
			return head;
		}
		//prev points to one before node to be reversed prev.next = newhad
		
		//start reversing
		ListNode revprev = null; //for now
		ListNode start = temp;
		while (temp != null && iter <= n) {
			curr = temp.next;
			temp.next = revprev;
			revprev = temp;
			temp = curr;
			iter++;
		}
		if (prev != null)
			prev.next = revprev;
		if (temp != null)
			start.next = temp;
		if (head == start && revprev != null)
			head = revprev;
        return head;
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
		ReverseLinkedList2 rl = new ReverseLinkedList2();
		for (int i = 11; i > 2;i--) {
			rl.addAtHead(i);
		}
		rl.printlist(rl.head);
		rl.printlist(rl.reverseBetween(rl.head,1,10));
	}
}	
