package teel;

public class MaximumProductSubarray {
	 public int maxSubArray(int[] nums) {
		 int imax, imin, ret, i;
		 imax = imin = ret = nums[0];
		 
		 for (i = 1; i < nums.length; i++) {
			 if (nums[i] < 0) {
				 int temp = imax; imax = imin; imin = temp;
			 }
			 imax = Math.max(nums[i], imax*nums[i]);
			 imin = Math.min(nums[i], imin*nums[i]);
			 ret = Math.max(ret, imax);
		 }
		 return ret;
	 }
	    
	    public static void main(String []args) {
	    	MaximumProductSubarray msa = new MaximumProductSubarray();
	    	int []nums = {3,-1,4};
	    	System.out.println(msa.maxSubArray(nums));
	    }
}
