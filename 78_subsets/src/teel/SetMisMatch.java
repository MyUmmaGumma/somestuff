package teel;

import java.util.Arrays;

public class SetMisMatch {
	public int[] findErrorNums(int[] nums) {

		int []ret = new int[2];
		Arrays.sort(nums);

		int prev = nums[0], missing = 0, dup = 0, expected = prev+1; 
		boolean founddup = false, foundmissing = false;
		if (prev != 1) {
			foundmissing = true;
			missing = 1;
		}
		for (int i = 1; i < nums.length; i++) {
			
			if (missing == nums[i]) {
				foundmissing = false;
			}
			if (nums[i] != expected && foundmissing == false) {
				missing = expected;
				foundmissing = true;
			}
			if (prev == nums[i]) {
				dup = prev;
				founddup  = true;
			} else {
				prev = nums[i];
				expected = prev + 1;
			}
		}
		
		if (foundmissing == false) {
			missing = nums[nums.length-1] + 1;
		}
		
		ret[0] = dup; ret[1] = missing;
		return ret;
    }
	
	public static void main(String []args)
	{
		SetMisMatch fdn = new SetMisMatch();
		int arr[] = {1,5,3,2,2,7,6,4,8,9};
		int x[] = fdn.findErrorNums(arr);
		System.out.println(x[0] + " " + x[1]);
	}
}
