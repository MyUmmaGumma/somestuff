package teel;

import java.util.HashSet;
import java.util.Set;

class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	         next = null;
	      }
	  }

public class LinkedListCycle2 {
	 Set<ListNode> l = new HashSet<ListNode>();
	 
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode ls = head;
		boolean found = false;
		while(ls != null && found == false) {
			if (l.contains(ls)) {
				found = true;
				break;
			}
			
			l.add(ls);
			ls = ls.next;
		}
		if (found)
			return ls;
		else
			return null;
    }
}
