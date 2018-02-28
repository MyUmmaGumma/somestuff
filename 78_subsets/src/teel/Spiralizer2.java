package teel;

import java.util.Arrays;

public class Spiralizer2 {
	public int[][] generateMatrix(int n) {
		int [][]matrix = new int[n][n];
		if (n ==0) return matrix;
		int smaller = Math.min(matrix.length, matrix[0].length);
        int i = 1;
        for (int k = 0; k <= smaller/2; k++) {
			for (int j = k; j < matrix[0].length - k;j++) {
				matrix[k][j] = i;
				i++;
			}
			for (int j = k+1; j < matrix.length - k;j++) {
				matrix[j][n-k-1] = i ;
				i++;
			}
			for (int j = matrix[0].length - k - 2; j >= k;j--) {
				matrix[n-k-1][j] = i ;
				i++;
			}
			for (int j = matrix.length - k - 2; j >= k+1;j--) {
				matrix[j][k] = i ;
				i++;	
			}
        }
		return matrix;
    }
	public static void main(String []args)
	{
		Spiralizer2 sp2 = new Spiralizer2();
		int [][] n = sp2.generateMatrix(2);
		System.out.println(Arrays.deepToString(n));
	}
}
