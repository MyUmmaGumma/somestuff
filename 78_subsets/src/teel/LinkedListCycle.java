package teel;

public class LinkedListCycle {
	 public boolean hasCycle(ListNode head) {
		 if (head == null || head.next == null) return false;
		 ListNode one = head.next;
		 if (one.next == null) {
			 return false;
		 }
		 ListNode two = head.next.next;
		 while (one != null && two != null && one != two) {
			 one = one.next;
			 if(two.next != null && two.next.next != null) {
				 two = two.next.next;
			 } else {
				 return false;
			 }
		 }
		 
		 if (one == two) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 ListNode tail;
	 public ListNode head;
	 public void add(int num) {
		 if (head == null) {
			 head = tail = new ListNode(num);
		 } else {
			 ListNode newnode = new ListNode(num);
			 tail.next = newnode;
			 tail = newnode;
		 }
	 }
	 
	 public void changeTail()
	 {
		 tail.next = head;
	 }
	 
	 public static void main(String []args)
	 {
		 LinkedListCycle llc = new LinkedListCycle();
		 llc.add(3);
		 llc.add(2);llc.add(0);llc.add(-4);
		 llc.changeTail();
		 System.out.println(llc.hasCycle(llc.head));
	 }
}
