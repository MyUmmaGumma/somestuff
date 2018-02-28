package teel;

public class HouseRobber2 {
		public int rob(int[] nums) {
			if (nums == null) { return 0; }
			if (nums.length == 1) { return nums[0]; }
			
			int max2 = Math.max(nums[0], nums[1]);
			if (nums.length == 2) { return max2; }
			
			int []rob0 = new int [nums.length + 1];
			int []rob1 = new int [nums.length + 1];
			rob0[0] = 0; rob0[1] = nums[0]; //I robbed house 0
			rob1[0] = 0; //I started at house 1 so i didnt rob house 0
			rob1[1] = 0; //I started at house 1 but the rob value of next house that is house 2 will reflect the right value
			
			for(int i = 2; i <= nums.length; i++) {
				rob0[i] = Math.max(rob0[i-2] + nums[i-1], rob0[i-1]);
				rob1[i] = Math.max(rob1[i-2] + nums[i-1], rob1[i-1]);
			}
			return Math.max(rob0[nums.length - 1], rob1[nums.length]);
	    }
}
