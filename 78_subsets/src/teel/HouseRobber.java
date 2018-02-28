package teel;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null) { return 0; }
		if (nums.length == 1) { return nums[0]; }
		
		int max2 = Math.max(nums[0], nums[1]);
		if (nums.length == 2) { return max2; }
		
		int []memo = new int [nums.length];
		memo[0] = nums[0];
		memo[1] = max2;
		
		for (int i = 2; i < memo.length; i++) {
			memo[i] = Math.max(memo[i-1], memo[i-2]+nums[i]);
		}
		return memo[nums.length - 1];
    }
}
