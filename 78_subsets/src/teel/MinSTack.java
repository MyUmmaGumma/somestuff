package teel;

import java.util.LinkedList;
import java.util.List;

public class MinSTack {
	List<Integer> stk; 
	List<Integer> min;
	
	/** initialize your data structure here. */
    public MinSTack() {
        stk = new LinkedList<Integer>();
        min = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        stk.add(x);
        int minsofar = (min.size() > 0) ? min.get(min.size() - 1) : Integer.MAX_VALUE;
        if (x < minsofar) {
        		min.add(x);
        } else {
        		min.add(minsofar);
        }
    }
    
    public void pop() {
    		stk.remove(stk.size()-1);
    		min.remove(min.size()-1);
    }
    
    public int top() {
        return stk.get(stk.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size() - 1);
    }
    
    public static void main(String []args)
    {
    		MinSTack minStack = new MinSTack();
    		minStack.push(-2);
    		minStack.push(0);
    		minStack.push(-3);
    		System.out.println(minStack.getMin());
    		minStack.pop();
    		System.out.println(minStack.top());     
    		System.out.println(minStack.getMin()); 
    }
}
