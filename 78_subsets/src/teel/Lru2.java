package teel;

import java.util.HashMap;
import java.util.Map;

public class Lru2 {
	   	class DListNode
		{
			DListNode prev;
			DListNode next;
			int val, key;
			public DListNode(int _val, int _key) {
				val = _val;
				key = _key;
				prev = next = null;
			}
		}
		
		private DListNode evictAndAdd(int val, int key)
		{
			//Remove from start and add at end
			if (head == null) {
				DListNode dln = new DListNode(val, key);
				if (tail == null) {
					head = tail = dln;
				} else {
					head = dln;
				}
				return dln;
			}
	        if (head == tail) {
	            head.val = val;
	            return head;
	        }
			head.val = val;
			DListNode temp = head;
			head = head.next;
			head.prev = null;
			tail.next = temp;
			temp.next = null;
			temp.prev = tail;
			tail = temp;
			return tail;
		}
		
		private DListNode addToEndOfList(int val, int key)
		{
			DListNode dln = new DListNode(val, key);
			if (tail != null) {
				tail.next = dln;
			}
			dln.prev = tail;
			tail = dln; 
			if (head == null) {
				head = tail;
			}
			return dln;
		}
		
		private void replaceAtEnd(DListNode dln)
		{
			//Remove from middle or beginning and place at end
			if(dln.next == null) {
				return;
			} 
			if (dln.prev == null) {
				evictAndAdd(dln.val, dln.key);
				return;
			}
			dln.prev.next = dln.next;
			dln.next.prev = dln.prev;
			tail.next = dln;
			dln.prev = tail;
			dln.next = null;
			tail = dln;
		}
		
		 int count = 0;
		 int capacity = 0;
		DListNode head, tail;
		Map<Integer, DListNode> m;
	    
		public Lru2(int _capacity) {
			m = new HashMap<>(capacity);
			capacity = _capacity;
			head = null; tail = null;
	    }
	    
	    public int get(int key) {
	    		if (capacity == 0 || count == -1) {
	    			return -1;
	    		}
	        if (m.containsKey(key)) {
	        		DListNode dln = m.get(key);
	        		replaceAtEnd(dln);
	        		return dln.val;
	        } else {
	        		return -1;
	        }
	    }
	    
	    public void put(int key, int value) {
	            if (capacity == 0) {
	                return;
	            }
		    	if (m.containsKey(key)) {
		    		DListNode dln = m.get(key);
	        		replaceAtEnd(dln);
		    	} else {
		    		DListNode dln = null;
		        if (count == capacity) {
	                    if (head != null) {
		        		    m.remove(head.key);
	                    }
		        		dln = evictAndAdd(value, key);
		        		
		        } else {
		        		dln = addToEndOfList(value, key);
		        		count++;
		        }
		        m.put(key, dln);
		    	}
	    }
	

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */
    
    public static void main(String []args)
    {
    		Lru2 lru2 = new Lru2(2);
    		lru2.put(1, 1);
    		lru2.put(2, 2);
    		System.out.println(lru2.get(1));
    		lru2.put(3,3);
    		System.out.println(lru2.get(2));
    		lru2.put(4,4);
    		System.out.println(lru2.get(1));
    		System.out.println(lru2.get(3));
    		System.out.println(lru2.get(4));
    		System.out.println();
    		Lru2 lru1 = new Lru2(1);
    		lru1.put(2, 1);
    		System.out.println(lru1.get(2));
    		lru1.put(3,2);
    		System.out.println(lru1.get(2));
    		System.out.println(lru1.get(3));
    			
    }
}
