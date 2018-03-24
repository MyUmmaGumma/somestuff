package teel;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int sum = 0, len = Integer.MAX_VALUE, j = 0, i = 0;
		if (nums.length ==0) return 0;
		for ( i = 0; i < nums.length;) {
			if (sum >= s) {
				while ( sum >= s) {
					len = Math.min(len, i - j);
					sum -= nums[j];
					j++;
				}
			} else {
				sum += nums[i];
				i++;
			}
		}
		while ( sum >= s) {
			len = Math.min(len, i - j);
			sum -= nums[j];
			j++;
		}
		return (len == Integer.MAX_VALUE) ? 0 : len;
	}
}
