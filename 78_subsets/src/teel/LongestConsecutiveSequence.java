package teel;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	 public int longestConsecutive(int[] nums) {
	      Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	      
	      for (int i = 0; i < nums.length; i++) {
	    	  	  if (!m.containsKey(nums[i])) {
	    	  		  m.put(nums[i], nums[i]);
	    	  	  }
	      }
	      
	      for (int i = 0; i < nums.length; i++) {
    	  		if (m.containsKey(nums[i] - 1)) {
    	  			int leader = m.get(nums[i] - 1);
    	  			if (leader == nums[i] - 1) {
    	  				int future_leader = -1;
    	  				if (m.containsKey(nums[i] + 1)) {
    	  					future_leader = m.get(nums[i] + 1);
    	  				} else {
    	  					future_leader = nums[i];
    	  				}
    	  				m.put(nums[i] - 1, future_leader);
	  					m.put(nums[i], future_leader);
    	  			} 
    	  		}
    	  		if (m.containsKey(nums[i]+1)) {
    	  			int future_leader = m.get(nums[i] + 1);
    	  			m.put(nums[i], future_leader);
    	  		}
    	  	 }
	      int longest = 0;
	      for (int i = 0; i < nums.length; i++) {
	    	    int curr = 0;
	    	    int start = nums[i];
	    	    int jumps = -1;
	    	  	while (m.get(start) != start) {
	    	  		int leader = m.get(start);
	    	  		curr += (leader - start) + 1;
	    	  		start = leader;
	    	  		jumps++;
	    	  	}
	    	    longest = Math.max(longest, curr - jumps);
	      }
	      return longest;
	 }
	 
	 public static void main(String []args)
	 {
		 LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		 int []nums = {100,4,200,1,3,2};
		 System.out.println(lcs.longestConsecutive(nums));
	 }
}
