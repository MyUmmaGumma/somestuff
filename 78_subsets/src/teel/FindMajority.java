package teel;

public class FindMajority {
	//Boyer-Moore Voting algorithm implementation - assumes n/2 elements are in majority
	public int majorityElement(int[] nums) {
		
		int count = 1, curr = nums[0];
		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 1; i < nums.length; i++) {
			if (count == 0) {
				curr = nums[i];
			}
			if (nums[i] == curr) {
				count++;
			} else {
				count--;
			}
		}
		return curr;
    }
}
