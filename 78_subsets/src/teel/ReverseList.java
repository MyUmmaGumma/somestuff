package teel;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (curr != null) {
        		temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
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
		ReverseList rl = new ReverseList();
		rl.addAtHead(5);rl.addAtHead(4);rl.addAtHead(3);rl.addAtHead(2);rl.addAtHead(1);
		rl.addAtHead(6);rl.addAtHead(7);rl.addAtHead(8);rl.addAtHead(9);rl.addAtHead(10);
		rl.printlist(rl.head);
		rl.printlist(rl.reverseList(rl.head));
	}
}
