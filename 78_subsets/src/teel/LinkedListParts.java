package teel;

import java.util.ArrayList;
import java.util.List;

public class LinkedListParts {
	 public ListNode[] splitListToParts(ListNode root, int k) {
		if (root == null) return null;
		
		ListNode temp = root;
		int count = 0;
		
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		int num = count / k;
		int rem = count % k;
		int []counts = new int [k];
		for (int i =0; i < k; i++) {
			if (rem > 0)
				counts[i] = num + 1;
			else 
				counts[i] = num;
			rem--;
		}
		
		temp = root;
		int i = 0;
		int elems= 0;
		ListNode start = root; 
		ListNode []ret = new ListNode[k];
		
		while (start != null && i < k) {
			ListNode end = start;
			temp = start;
			elems = 0;
			while (elems < counts[i]) {
				end = temp;
				temp = temp.next;
				elems++;
			}
			ret[i] = start;
			start = end.next;
			end.next = null;
			i++;
		}
		return ret;
	 }
	 
	 ListNode head;
	 void addAtHead(int val)
	{
		ListNode t = new ListNode(val);
		t.next = head;
		head = t;
		
	}
	
	void printlist(ListNode []ts)
	{
		for (ListNode t : ts) {
			while(t != null) {
				System.out.print(t.val + " " );
				t = t.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String []args)
	{
		LinkedListParts rl = new LinkedListParts();
		rl.addAtHead(5);rl.addAtHead(4);rl.addAtHead(3);rl.addAtHead(2);rl.addAtHead(1);
		rl.addAtHead(6);rl.addAtHead(7);rl.addAtHead(8);rl.addAtHead(9);rl.addAtHead(10);
		rl.printlist(rl.splitListToParts(rl.head, 10));
	}
}
