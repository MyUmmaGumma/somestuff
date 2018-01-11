package teel;

import java.util.Iterator;

public class PeekingIterator  implements Iterator<Integer> {
		Iterator<Integer> iter;
		Integer next;
		
		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
			iter = iterator;
			next = iter.hasNext() ? iter.next() : null;
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	      return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
			Integer ret = next;
			next = iter.hasNext() ? iter.next() : null;
			return ret;
		}

		@Override
		public boolean hasNext() {
			if (next == null) {
				return false;
			} else {
				return  true;
			}
		}
	
}
