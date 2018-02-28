package teel;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequences {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return 1;
		
		int []counts = new int [nums.length];
		int []lengths = new int [nums.length];
		Arrays.fill(counts, 1);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					if (lengths[i] <= lengths[j]) {
						lengths[i] = lengths[j] + 1;
						counts[i] = counts[j];
					} else if (lengths[i] == lengths[j]+1) {
						counts[i] += counts[j];
					}
				}
			}
		}
		int longest = 0, ans = 0;
		for (int i = 0; i < lengths.length; i++) {
			longest = Math.max(longest, lengths[i]);
		}
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == longest) {
				ans += counts[i];
			}
		}
		return ans;
	}
}
