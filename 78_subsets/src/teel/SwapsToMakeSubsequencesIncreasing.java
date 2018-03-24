package teel;

public class SwapsToMakeSubsequencesIncreasing {
	//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/solution/
	public int minSwap(int[] A, int[] B) {
		int swaps = 0, n1= 0, n2 = 0, s1 = 1, s2 = 0;
		for (int i = 1; i < B.length; i++) {
			n2 = Integer.MAX_VALUE; s2 = Integer.MAX_VALUE; 
			if (A[i-1] < A[i] && B[i-1] < B[i]) {
				n2 = Math.min(n2, n1);
				s2 = Math.min(s2, s1 + 1);
			}
			if (A[i-1] < B[i] && A[i-1] < B[i]) {
				n2 = Math.min(n2, s1);
				s2 = Math.min(s2, n1 + 1);
			}
			n1 = n2;
			s1 = s2;
		}
		return Math.min(n1, s1);
	}
}
