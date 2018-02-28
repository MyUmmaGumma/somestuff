package teel;

import java.util.Arrays;

public class NonDecreasingArray {
	public int firstAnomaly (int []nums)
	{
		for (int i = 0; i + 1 < nums.length; i++) {
			if (nums[i] > nums[i+1]) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean checkPossibility(int[] nums) {
		if (nums.length == 0) { 
			return false;
		}
		if (nums.length == 1) {
			return true;
		}
		int i = firstAnomaly(nums);
		if (i == -1) {
			return true;
		}
		if (i == nums.length -1) {
			return true;
		}
		if (i == 0) {
			nums[0] = nums[1];
		} else {
			if (nums[i] < nums[i-1]) {
				nums[i] = nums[i-1];
			} else if (nums[i] > nums[i+1]) {
				nums[i+1] = nums[i-1];
			}
		}
		return (firstAnomaly(nums) == -1);
    }
}
