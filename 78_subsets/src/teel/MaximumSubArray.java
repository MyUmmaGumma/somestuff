package teel;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
    	int max = Integer.MIN_VALUE,running = Integer.MIN_VALUE;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] > running && running < 0) {
    			running = nums[i];
    		} else {
    			running = running + nums[i];
    		}   		
    		if (max < running) {
    			max = running;
    		}
    	}
        return max;
    }
    
    public static void main(String []args) {
    	MaximumSubArray msa = new MaximumSubArray();
    	int []nums = {-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(msa.maxSubArray(nums));
    }
	    
}

