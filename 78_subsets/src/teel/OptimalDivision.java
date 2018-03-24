package teel;

public class OptimalDivision {
	class Result {
		String minstr, maxstr;
		float minval, maxval;
	}
	
	 public String optimalDivision(int[] nums) {
		 Result result = optimal_int(nums, 0, nums.length-1);
		 return result.maxstr;
	 }
	 
	 private Result optimal_int(int []nums, int start, int end)
	 {
		 Result r = new Result();
		 if (start == end) {
			 r.minval = r.maxval = nums[start];
			 r.maxstr = r.minstr = "" + nums[start];
			 return r;
		 }
		 r.minval = Float.MAX_VALUE;
		 r.maxval = Float.MIN_VALUE;
		 r.maxstr = r.minstr = "";
		 
		 for (int i=start; i < end; i++) {
			 Result left = optimal_int(nums, start, i);
			 Result right = optimal_int(nums, i+1, end);
			 
			 if (r.minval > left.minval/right.maxval) {
				 r.minval = left.minval/right.maxval;
				 if (i+1 == end) {
					 r.minstr = left.minstr +  "/" + right.maxstr;
				 } else {
					 r.minstr = left.minstr +   "/" + "(" + right.maxstr + ")";
				 }
			 }
			 if (r.maxval < left.maxval/right.minval) {
				 r.maxval = left.maxval/right.minval;
				 if (i+1 == end) {
					 r.maxstr = left.maxstr + "/" + right.minstr;
				 } else {
					 r.maxstr = left.maxstr + "/" + "(" + right.minstr + ")";
				 }
			 }
		 }
		 return r;
	 }
}
