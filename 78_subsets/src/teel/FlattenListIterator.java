package teel;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenListIterator {
	  public interface NestedInteger {
		 
		      // @return true if this NestedInteger holds a single integer, rather than a nested list.
		      public boolean isInteger();
		 
		      // @return the single integer that this NestedInteger holds, if it holds a single integer
		      // Return null if this NestedInteger holds a nested list
		      public Integer getInteger();
		 
		     // @return the nested list that this NestedInteger holds, if it holds a nested list
		     // Return null if this NestedInteger holds a single integer
		     public List<NestedInteger> getList();
		  }
		 
		public class NestedIterator implements Iterator<Integer> {
			Stack<NestedInteger> si = null;
		    public NestedIterator(List<NestedInteger> nestedList) {
		    		si = new Stack<>();
		    		for (int i = nestedList.size() - 1; i >=0;i--) {
        				si.push(nestedList.get(i));
        			}
		    }

		    @Override
		    public Integer next() {
		        return si.pop().getInteger();
		    }

		    @Override
		    public boolean hasNext() {
		        if (!si.isEmpty() && si.peek().isInteger()) {
		        		return true;
		        } else {
		        		while (!si.isEmpty()) {
		        			if (si.peek().isInteger()) {
		        				return true;
		        			}
		        			List<NestedInteger> lni = si.peek().getList();
		        			for (int i = lni.size() - 1; i >=0;i--) {
		        				si.push(lni.get(i));
		        			}
		        		}
		        }
		        return false;
		    }
		}
}
