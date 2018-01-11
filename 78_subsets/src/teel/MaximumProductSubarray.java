package teel;

public class MaximumProductSubarray {
	 public int maxSubArray(int[] nums) {
	    	int max = Integer.MIN_VALUE,running = 0, negative = 0;
	    	for (int i = 0; i < nums.length; i++) {
	    		if (nums[i] < 0) {
	    			if (negative == 0) {
	    				negative = nums[i];
	    				//running *= nums[i];
	    				if (max < negative) {
	        				max = negative;	
	        			}
	    				
	    				continue;
	    			} else {
	    				if (running > 0 ) {
	    					running = running * negative * nums[i];
	    				} else {
	    					running = negative * nums[i];;
	    				}
	    				negative = 0;
	    				if (max < running) {
		    				max = running;	
		    			}
	    			}
	    		} else if (nums[i] == 0) {
	    			if (max < running) {
	    				max = running;	
	    			}
	    			running = 0;
					negative = 0;
					continue;
	    		} else {
	    			if (running == 0) {
	    				running = nums[i];
	    			} else {
	    				if (negative != 0) {
	    					running = running * nums[i];
	    				}
	    			}
	    			if (max < running) {
	    				max = running;	
	    			}
	    		}
	    		
	    	}
	        return max;
	    }
	    
	    public static void main(String []args) {
	    	MaximumProductSubarray msa = new MaximumProductSubarray();
	    	int []nums = {3,-1,4};
	    	System.out.println(msa.maxSubArray(nums));
	    }
}
