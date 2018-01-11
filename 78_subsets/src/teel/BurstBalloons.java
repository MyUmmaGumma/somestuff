package teel;

public class BurstBalloons {
	public int maxCoins(int[] inums) {
		int []nums = new int [inums.length + 2];
		int i = 1;
		for (i = 1; i < inums.length; i++) {
			nums[i] = inums[i-1];
		}
		nums[0] = nums[i++] = 1;
		int [][]memo = new int [i][i];
		
		return burst(memo, nums, 0, i-1);
    }
	
	public int burst(int [][] memo, int []nums, int left, int right)
	{
		int ans = 0;
		if (left + 1 == right) return memo[left][right];
		
		if (memo[left][right] > 0) {
			return memo[left][right];
		}
		
		for (int i = left+1; i < right; i++) {
			ans = Math.max(ans, burst(memo, nums, left, i) + nums[left] * nums[i] * nums[right] +
					burst(memo, nums, i, right));
		}
		memo[left][right] = ans;
		return memo[left][right];
	}
}
