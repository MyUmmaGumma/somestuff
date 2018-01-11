package teel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TwoSum {
	HashMap<Integer, Integer> foo = new HashMap<Integer, Integer>();
	public int[] twoSum(int[] nums, int target) {
	    for (int i = 0; i < nums.length; i++) {
	    	if (foo.containsKey(target - nums[i])) {
	    		return new int[]{foo.get(target-nums[i]), i};
	    	}
	    	foo.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No solution found"); 
	}
	
	public int[] twoSumsorted(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(true) {
        	if (nums[i] + nums[j] == target) {
        		break;
        	}
        	else if(nums[i] + nums[j] > target) {
        		j--;
        	} else {
        		i++;
        	}
        }
        return new int[]{i+1, j+1};
         
    }
	
	public static void main(String []args)
	{
		TwoSum t = new TwoSum();
		int []nums = {3,2,4};
		int []ret = t.twoSum(nums, 6);
		System.out.println(ret[0] +  "  " +ret[1]);
		int []nums1 = {1,2,3,4,5,6,7,8,9};
		int []ret1 = t.twoSumsorted(nums1, 16);
		System.out.println(ret1[0] +  "  " +ret1[1]);
	}
}
