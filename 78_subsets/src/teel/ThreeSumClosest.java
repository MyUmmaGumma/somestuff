package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
	 public int threeSumClosest(int[] nums, int target) {
			Arrays.sort(nums);
			int result = nums[0] + nums[1] + nums[nums.length - 1];
			int sum = Integer.MAX_VALUE;
			int mindiff = Integer.MAX_VALUE;
			for (int i = 0; i < nums.length; i++) {
			
				int lo = i + 1, hi = nums.length -1;
				
				while (lo < hi) {
					sum = nums[i] + nums[lo] + nums[hi];
					if (sum > target) {
						hi--;
					} 
					if (sum < target) {
						lo++;
					}
					if (Math.abs(sum - target) < mindiff) {
						mindiff = sum;
					}
					if (Math.abs(sum - target) < Math.abs(result - target)) {
	                    result = sum;
	                }
				}
			}
			return result;
	 }
	 
	 public static void main(String []args)
		{
			int []nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
			ThreeSumClosest ts = new ThreeSumClosest();
			int i = ts.threeSumClosest(nums, -7);
			System.out.println(i);
			
		}
}
