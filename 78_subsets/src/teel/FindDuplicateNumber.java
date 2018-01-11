package teel;

import java.util.Arrays;

public class FindDuplicateNumber {
	public int findDuplicate(int[] nums) {
		if (nums.length == 2) {
			return nums[0];
		}
		Arrays.sort(nums);
		int prev = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (prev == nums[i]) {
				return prev;
			} else {
				prev = nums[i];
			}
		}
		return prev;
    }
	
	public static void main(String []args)
	{
		FindDuplicateNumber fdn = new FindDuplicateNumber();
		int arr[] = {10,20,30,30,8,9,30,1,2};
		System.out.println(fdn.findDuplicate(arr));
	}
}
