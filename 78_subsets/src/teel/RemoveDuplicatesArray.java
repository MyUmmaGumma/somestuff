package teel;

public class RemoveDuplicatesArray {
	public int removeDuplicates(int[] nums) {
		int iter = 0, unique = 1;
		if (nums.length <= 1) { return nums.length;}
		for (iter = 1; iter < nums.length; iter++) {
			if (nums[iter-1] != nums[iter]) {
				if (unique != iter) {
					nums[unique] = nums[iter];
				}
				unique++;
			}
		}
		return unique;
    }
}
