package teel;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedTest {
		Map<Integer, Integer> m;
		List<Integer> list;
		Random rand;
		
		 /** Initialize your data structure here. 
		 * @return */
	    public RandomizedTest() {
	    		m = new HashMap<>();
	    		list = new ArrayList<>();
	    		rand = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if (m.containsKey(val)) {
	        		return false;
	        }
	        list.add(val);
	        m.put(val, list.size()-1);
	        
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if (m.containsKey(val)) {
	        		//Located somewhere in middle of list
	        		int alist_loc_to_swap = m.get(val);
	        		if (alist_loc_to_swap < list.size() - 1) {
	        			int list_last_element = list.get(list.size()-1);
	        			list.set(alist_loc_to_swap, list_last_element);
	        			
	        			m.put(list_last_element, alist_loc_to_swap);
	        		}
	        		list.remove(list.size()-1);
	        		m.remove(val);
	        		return true;
	        }
	        return false;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	    		int num;
	    		
	    			num = rand.nextInt()  & Integer.MAX_VALUE;;
	    		
	        return list.get(num %list.size());
	    }
	    
	    public static void main(String []args)
	    {
	    		RandomizedTest obj = new RandomizedTest();
	    		boolean param_1 = obj.insert(1);
	    		System.out.println(param_1);
	    		boolean param_2 = obj.remove(2);
	    		System.out.println(param_2);
	    		boolean param_3 = obj.insert(2);
	    		System.out.println(param_3);
	    		int val = obj.getRandom();
	    		System.out.println(val);
	    		 param_2 = obj.remove(1);
	    		System.out.println(param_2);
	    }
}	
