package teel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/* Merge k Sorted Lists */
public class MergeKLists {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		      public void printlist()
				 {
					 ListNode temp = this;
					 while(temp != null) {
						 System.out.print("->" + temp.val);
						 temp = temp.next;
					 }
					 System.out.println("->EOL");
				 }
	 }
	 
	 public class LList {
		 public ListNode head = null;
		 
		 public void insertAtHead(int val) {
			 ListNode l = new ListNode(val);
			 if (head == null) {
				 head = l;
			 } else{
				 l.next = head;
				 head = l;
			 }
		 }
		 public void insertAtHead(int []vals) {
			 for(int val : vals) {
				 ListNode l = new ListNode(val);
				 if (head == null) {
					 head = l;
				 } else{
					 l.next = head;
					 head = l;
				 }
			 }
		 }
		 
		 public void printlist()
		 {
			 ListNode temp = head;
			 while(temp != null) {
				 System.out.print("->" + temp.val);
				 temp = temp.next;
			 }
			 System.out.println("->EOL");
		 }
	 }
	 
	 public class HeapNode {
		 ListNode ln;
		 int nodelistnum;
		 HeapNode(ListNode i, int j) 
		 {
			 ln= i;
			 nodelistnum = j;
		 }
	 }
	 
	 public static Comparator<HeapNode> hncomp = new Comparator<HeapNode>() {
		 @Override
		 public int compare(HeapNode o1, HeapNode o2) {
			 HeapNode h1 = (HeapNode)o1;
			 HeapNode h2 = (HeapNode)o2;
			 return (int)h1.ln.val - h2.ln.val;
		 }
	 };
	 
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null)
			return null;
		if (lists.length == 1) return lists[0];
		if (lists.length == 0) return null;
		
		int optimization = 0;
		PriorityQueue<HeapNode> pqh = new PriorityQueue<HeapNode>(lists.length, hncomp);
		for(int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				pqh.add(new HeapNode(lists[i], i));
				if (lists[i].next != null) {
					lists[i] = lists[i].next;
				} else {
					lists[i] = null;
					optimization++;
				}
			}
		}
		
		ListNode res = null;
		ListNode tail = null;
		
		if (optimization == lists.length) {
			res = tail = pqh.remove().ln;
			while (!pqh.isEmpty()) {
				HeapNode h = pqh.remove();
				tail.next = h.ln;
				tail = h.ln;
			}
		}
		
		while (!pqh.isEmpty()) {
			HeapNode h = pqh.remove(); 
			if (res == null) {
				res = h.ln;
				tail = h.ln;
			} else {
				tail.next = h.ln;
				tail = h.ln;
			}
			if (lists[h.nodelistnum] == null || h.ln == null){
				continue;
			}
			ListNode next = lists[h.nodelistnum];
			if (next == null) {
				continue;
			} else {
				pqh.add(new HeapNode(next, h.nodelistnum));
				lists[h.nodelistnum] = lists[h.nodelistnum].next;
			}
		}
		
		return res;
    }
	
	public static void main(String []args)
	{
		MergeKLists mk = new MergeKLists();
		/*MergeKLists.LList l1 = mk.new LList();
		MergeKLists.LList l2 = mk.new LList();
		int arr1[] = {55};
		l2.insertAtHead(arr1);*/
		
		
		MergeKLists.LList l1 = mk.new LList();
		//int arr[] = {50,40,30,20,10};
		int arr[] = {50};
		l1.insertAtHead(arr);
		l1.printlist();
		
		MergeKLists.LList l2 = mk.new LList();
		//int arr1[] = {55,44,33,22,11};
		int arr1[] = {51};
		l2.insertAtHead(arr1);
		l2.printlist();
		
		MergeKLists.LList l3 = mk.new LList();
		//int arr2[] = {150,14,12,9,8};
		int arr2[] = {4};
		l3.insertAtHead(arr2);
		l3.printlist(); 
		
		MergeKLists.ListNode l[] = new MergeKLists.ListNode[3];
		l[0] = l1.head;
		l[1] = l2.head;
		l[2] = l3.head;
		MergeKLists.ListNode result = mk.mergeKLists(l);
		result.printlist();
	}
}

