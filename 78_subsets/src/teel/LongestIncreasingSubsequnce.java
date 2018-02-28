package teel;

import java.util.Arrays;

public class LongestIncreasingSubsequnce {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		
		int []lengths = new int [nums.length];
		Arrays.fill(lengths, 1);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lengths[i] = Math.max(lengths[i], lengths[j] + 1);
				}
			}
		}
		int longest = 0;
		for (int i = 0; i < lengths.length; i++) {
			longest = Math.max(longest, lengths[i]);
		}
		return longest;
    }
	
	public static void main(String []args)
	{
		LongestIncreasingSubsequnce lcs = new LongestIncreasingSubsequnce();
		//int []nums = {10,9,2,5,3,7,101,18};
		int []nums = {1,3,6,7,9,4,10,5,6};
		System.out.println(lcs.lengthOfLIS(nums));
	}
}
