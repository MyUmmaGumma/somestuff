package teel;

public class IntersectionLinkedList {
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempa = headA, tempb = headB;
        int counta = 0, countb = 0;
        while(tempa != null) {
        		tempa = tempa.next;
        		counta++;
        }
        while(tempb != null) {
	    		tempb = tempb.next;
	    		countb++;
        }
        tempa = headA; 
        tempb = headB;
        
        if (counta != countb) {
	        if (counta > countb) {
	        		while(counta != countb) {
	        			tempa = tempa.next;
	        			counta--;
	        		}
	        } else {
		        	while(counta != countb) {
	        			tempb = tempb.next;
	        			countb--;
	        		}
	        }
        }
        
        while (tempa != null && tempb != null && tempa != tempb) {
            tempa = tempa.next;
            tempb = tempb.next;
        }
        if (tempa != null && tempa == tempb) {
            return tempa;
        }
        return null;
	 }
	 ListNode headA, headB;
	 void addAtHead(int val)
	{
		ListNode t = new ListNode(val);
		t.next = headA;
		headA = t;
		
	}
	 void addAtHeadB(int val)
		{
			ListNode t = new ListNode(val);
			t.next = headB;
			headB = t;
			
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
		
		 IntersectionLinkedList rl = new IntersectionLinkedList();
		 rl.addAtHead(5);rl.addAtHead(4);rl.addAtHead(3);rl.addAtHead(2);rl.addAtHead(1);
		 rl.addAtHead(6);ListNode l = rl.headA; rl.addAtHead(7);rl.addAtHead(8);rl.addAtHead(9);rl.addAtHead(10);
		 rl.printlist(rl.headA);
		 rl.addAtHeadB(6);rl.addAtHeadB(7);rl.headB = l;rl.addAtHeadB(18);rl.addAtHeadB(19);
		 rl.printlist(rl.headB);
		 rl.getIntersectionNode(rl.headA, rl.headB);
	 }
}
