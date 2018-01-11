package teel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinSquares {
	public int numSquares(int n) {
		int dp[] = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int k = 1;
			while (i - k*k >= 0) {
				min = Math.min(min, dp[i - k*k] + 1);
				k++;
			}
			dp[i] = min;
		}
		return dp[n];
	}
	
	public static void main(String []args)
	{
		MinSquares ms =  new MinSquares();
		System.out.println(ms.numSquares(1));
	}
}

