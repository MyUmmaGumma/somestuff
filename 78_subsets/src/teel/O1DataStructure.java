package teel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class O1DataStructure {
	private class MyInt
	{
		
	}
	/** Initialize your data structure here. */
    public O1DataStructure() {
    		PriorityQueue<String> minh= new PriorityQueue<String>(new Comparator<String>()
    				{
    					public int compare(String arg00, String arg11) {
    						Integer arg0 = Integer.valueOf(arg00);
							Integer arg1 = Integer.valueOf(arg00);
							if (arg0 < arg1) {
								return -1;
							} else if (arg0 > arg1) {
								return 1;
							} else {
								return 0;
							}
    					}
    				}
    		);
    		PriorityQueue<String> maxh= new PriorityQueue<String>(new Comparator<String>()
    				{

						@Override
						public int compare(String arg00, String arg11) {
							Integer arg0 = Integer.valueOf(arg00);
							Integer arg1 = Integer.valueOf(arg00);
							if (arg0 < arg1) {
								return 1;
							} else if (arg0 > arg1) {
								return -1;
							} else {
								return 0;
							}
						}
    				}
    		);
    		Map<String, Integer> hm = new HashMap<String, Integer>();
    		
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return "";
    }
    
}
