package teel;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
	private int longestPalindromeSubseq_int(String s, int l, int r, int [][]lr)
	{
		if (l > r) {
			return 0;
		}
		if (lr[l][r] != 0) {
			return lr[l][r];
		} else {
			if (s.charAt(l) == s.charAt(r)) {
				if (l + 1 <= r-1) {
					lr[l][r] = longestPalindromeSubseq_int(s, l+1, r-1, lr) + 2;
				} else {
					lr[l][r] = 2;
				}
			} else {
				lr[l][r] = Math.max(longestPalindromeSubseq_int(s, l+1, r, lr), 
						longestPalindromeSubseq_int(s, l, r-1, lr)); 
			}
			return lr[l][r];
		}
	}
	
	public int longestPalindromeSubseq(String s) {
		int l = 0, r = s.length();
		int [][]lr = new int [r][];
		for (int i = 0; i < lr.length; i++) {
			lr[i] = new int [r];
			Arrays.fill(lr[i], 0);
 		}
		for (int i = 0; i < lr.length; i++) {
			lr[i][i] = 1;
		}
		longestPalindromeSubseq_int(s, l, r-1, lr);
		return lr[0][r-1];
    }
}
