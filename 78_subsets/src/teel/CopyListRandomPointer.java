package teel;

import java.util.HashMap;
import java.util.Map;

public class CopyListRandomPointer {
	/**
	 A linked list is given such that each node 
	 contains an additional random pointer which could point
	  to any node in the list or null.
	  Definition for singly-linked list with a random pointer.
	 */
	  class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
	  };
	 
	
	    public RandomListNode copyRandomList1(RandomListNode head) {
	    		RandomListNode rln = head;
	    		RandomListNode dummy = new RandomListNode(0);
	    		RandomListNode newdummy = dummy;
	    		Map<RandomListNode, Integer> m = new HashMap<RandomListNode, Integer>();
	    		int distance = 0;
	        while(rln != null) {
	        		newdummy.next = new RandomListNode(rln.label);
	        		m.put(rln, distance++);
	        		rln = rln.next;
	        		newdummy = newdummy.next;
	        }
	        rln = head;
	        newdummy = dummy.next;
	        while(rln != null) {
	        		int dist = (rln.random != null) ? m.get(rln.random) : -1;
	        		if (dist != -1) {
	        			RandomListNode temp = newdummy.next;
	        			for (int i= 0; i < dist;i++) {
	        				temp = temp.next;
	        			}
	        			newdummy.random = temp.random;
	        		}
	        		newdummy = newdummy.next;
	        		rln = rln.next;
	        }
	        	return newdummy.next;
	    }
	    
	    public RandomListNode copyRandomList(RandomListNode head) {
	    		//Make a copy of the node and store in a map, dont update pointers yet
	    		Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
	    		RandomListNode temp = head;
	    		while (temp != null) {
	    			m.put(temp, new RandomListNode(temp.label));
	    			temp = temp.next;
	    		}
	    		//Update the pointers here
	    		temp = head;
	    		while (temp != null) {
	    			m.get(temp).next = m.get(temp.next);
	    			m.get(temp).random = (temp.random == null) ? null : m.get(temp.random);
	    		}
	    		return m.get(head);
	    }
}
