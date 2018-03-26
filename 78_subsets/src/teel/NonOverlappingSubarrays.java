package teel;

public class NonOverlappingSubarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int sum = Integer.MIN_VALUE, sum1 = 0, sum2 = 0, sum3 = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < k && j < nums.length; j++) {
				sum1 += nums[j];
			}
			for (int j = i+k-1; j < k && j < nums.length; j++) {
				sum2 += nums[j];
			}
			for (int j = i+2*k-2; j < k && j < nums.length; j++) {
				sum3 += nums[j];
			}
			if (sum1 + sum2 + sum3 > sum) {
				sum = sum1 + sum2 + sum3; 
			}
		}
		return new int [] {0};
    }
}
