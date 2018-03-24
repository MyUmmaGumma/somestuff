package teel;

public class MaximumLengthRepeatedSubarray {
	/*
	 * Enumerate sub-arrays in an array
	 *  for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				for (int k = 0; k + i <= j; k++) {
					System.out.print(" " + A[i+k]);
				}
				System.out.println("");
			}
        }
	 */
	
	public int findLength(int[] A, int[] B) {
		int [][]mn = new int [A.length+1][B.length+1];
		for (int i = 0; i < mn.length; i++) {
			mn[0][i] = 0;
		}
		for (int i = 0; i < mn.length; i++) {
			mn[i][0] = 0;
		}
		int len = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if (B[j] == A[i]) {
					mn[i+1][j+1] = Math.max(mn[i+1][j+1], mn[i][j] + 1);
					len = Math.max(len, mn[i+1][j+1]);
				}
			}
		}
        return len;
    }
}
