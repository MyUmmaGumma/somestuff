package teel;

import java.util.Arrays;

public class LargestPlusSign {
	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int [][]leftmemo = new int [N][N];
		int [][]rightmemo = new int [N][N];
		int [][]topmemo = new int [N][N];
		int [][]downmemo = new int [N][N];
		
		for (int i =0; i < N; i++) {
			Arrays.fill(leftmemo[i], N);
			Arrays.fill(rightmemo[i], N);
			Arrays.fill(topmemo[i], N);
			Arrays.fill(downmemo[i], N);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mines[i][j] == 0) {
					rightmemo[i][j] = 0;
					leftmemo[i][j] = 0;
					topmemo[i][j] = 0;
					downmemo[i][j] = 0;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			int left = 0;
			for (int j = 0; j < N; j++) {
				if (leftmemo[i][j] == 0) {
					leftmemo[i][j] = 0;
				} else {
					leftmemo[i][j] = left + 1;
				}
			}
			int right = 0;
			for (int j = N-1; j >= 0; j--) {
				if (leftmemo[i][j] == 0) {
					leftmemo[i][j] = 0;
				} else {
					rightmemo[i][j] = right + 1;
				}
			}
			int top = 0;
			for (int j = 0; j < N; j++) {
				if (leftmemo[j][i] == 0) {
					leftmemo[j][i] = 0;
				} else {
					leftmemo[j][i] = top + 1;
				}
			}
			int bottom = 0;
			for (int j = N-1; j >= 0; j--) {
				if (leftmemo[j][i] == 0) {
					leftmemo[j][i] = 0;
				} else {
					rightmemo[j][i] = bottom + 1;
				}
			}
		}
		
		int n = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int len = Math.min(Math.min(leftmemo[i][j], rightmemo[i][j]), 
						Math.min(topmemo[i][j], downmemo[i][j]));
				if (len > n) {
					n = len;
				}
			}
			
		}
		if (n > 0)
		       return 4 * (n - 1) + 1;
		 
		    // matrix contains all 0's
		    return 0;
	}
	
	public static void main(String []args)
	{
		LargestPlusSign lps = new LargestPlusSign();
		int N = 5;
		int [][]mines = {{0,1,1,0,0},{0,1,1,1,1},{1,1,1,0,0},{0,1,0,0,1},{0,1,1,0,1}};
		System.out.println(lps.orderOfLargestPlusSign(N, mines));
	}
}
