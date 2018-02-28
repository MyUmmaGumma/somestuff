package teel;

public class LongestContinousIncreasingSubsequence {
	public int findLengthOfLCIS(int[] nums) {
		int ret = 0;
		if (nums.length == 0) return ret;
		if (nums.length == 1) return 1;
		
		int streak = 1;
		for (int i = 0; i + 1 < nums.length;i++) {
			if (nums[i] < nums[i+1]) {
				streak++;
			} else {
				ret = Math.max(ret, streak);
				streak = 1;
			}
		}
		ret = Math.max(ret, streak);
		return ret;
    }
	
	public static void main(String []args)
	{
		LongestContinousIncreasingSubsequence lcis = new LongestContinousIncreasingSubsequence();
		//int []nums = {1,3,5,4,7};
//		int []nums = {2,2,2,2,2,2};
//		int []nums = {9,8,5,4,2,1};
		int []nums = {9,8,6,5,7};
		System.out.println(lcis.findLengthOfLCIS(nums));
	}
}
