package teel;

import java.util.HashMap;
import java.util.LinkedList;

public class LRU {
	class Nodepos
	{
		public Node n;
		public int value;
	}
	
	HashMap<Integer, Nodepos> hm = new HashMap<Integer, Nodepos>();
	int size; int capacity;
	DoublyLinkedList dls = new DoublyLinkedList();
	

	class Node {
		int val;
		Node prev, next;
		public Node (int v)
		{
			prev= next = null;
			val = v;
		}
	}
	
	class DoublyLinkedList {
		
		Node beg, end;
		public DoublyLinkedList()
		{
			beg = end = null;
		}
		
		public Node add(int v) {
			Node n = new Node(v);
			if (beg == null) {
				beg = end = n;
			} else {
				beg.prev = n;
				n.next = beg;
				beg = n;
			}
			return n;
		}
		
		public Node removeEnd() {
			if (end == null) {
				return null;
			} 
			if (end.prev == null) {
				return end;
			} else {
				end.prev.next = null;
				Node temp = end;
				end = end.prev;
				return temp;
			}
		}
		
		public void removeAndAddAtBeg(Node n) {
			if (n.prev == null) {
				//Already node is at the beg
				return;
			} else {
				if (n.next != null) {
					n.prev.next = n.next;
					n.next.prev = n.prev;
				} else {
					//remove from end
					n.prev.next = null;
					end = n.prev;
				}
				//Add node to beg
				n.prev = null;
				n.next = beg;
				beg = n;
			}
		}
	}
	
	public LRU(int capacity) {
		this.capacity = capacity;
		size = 0;
    }
    
    public int get(int key) {
        if (hm.containsKey(key)) {
        	Nodepos np = hm.get(key);
        	dls.removeAndAddAtBeg(np.n);
        	System.out.println("Returning " + np.value);
        	return np.value;
        } else {
        	System.out.println("Returning -1");
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        if (size == capacity) {
        	//evict and add
        	Node n = dls.removeEnd();
        	if (n == null) {
        		System.out.println("Nothing to remove, so cannot add!");
        		return;
        	} else {
        		hm.remove(n.val);
        		Nodepos np = new Nodepos();
            	np.value = value;
            	np.n = dls.add(key);
            	hm.put(key, np);
        	}
        } else {
        	//just add
        	Nodepos np = new Nodepos();
        	np.value = value;
        	np.n = dls.add(key);
        	hm.put(key, np);
        	size++;
        }
        System.out.println("Added " + key + " , " + value);
    }
    
    public static void main(String []args)
    {
    	LRU cache = new LRU( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	cache.get(1);       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	cache.get(2);       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	cache.get(1);       // returns -1 (not found)
    	cache.get(3);       // returns 3
    	cache.get(4);       // returns 4
    }
}
