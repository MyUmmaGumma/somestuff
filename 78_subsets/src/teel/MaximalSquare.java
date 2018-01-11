package teel;

public class MaximalSquare {
	public int [][]res;
	
	public int maxSquare(int i, int j, int m, int n, char [][]a)
	{
		for (; i < m-1; i++) {
			for (; j < n-1; j++) {
				if (a[i][j] == 1 &&
						a[i+1][j] == 1 &&
						a[i][j+1] == 1 &&
						a[i+1][j+1] == 1) {
					res[i][j] = 1 + maxSquare(i+1, j+1, m, n, a);
				}
			}
		}
		return res[i][j];
	}
	
	public void maxSquareBruteForce(int i, int j, int m, int n, char [][]a)
	{
		int maxSqX= 0, maxSqY = 0, maxSize = 0;
		for (; i < m-1; i++) {
			for (; j < n-1; j++) {
				if (a[i][j] != 1) {
					continue;
				} 
				maxSqX = i; maxSqY = j;
				int currSize = 0;	
				for (int k = 1; k < m && k < n; k++ ) {
					boolean no11 = false;
					for (int findX = 0; findX < maxSqX + k ; findX++) {
						boolean no1 = false;
						for (int findY = 0; findY < maxSqY + k; findY++) {
							if (a[findX][findY] != 1) {
								no1 = true;
								break;
							}
						}
						if (no1 == true) {
							no11 = true;
							break;
						}
					}
					if (no11 == true) {
						if (currSize > maxSize) {
							maxSize = currSize;
						}
						break;
					}
					currSize += 1;
				}
			}
		}
	}
	
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		
		if (m == 1 || n == 1) {
			return 0;
		}
		
		res = new int[m-1][n-1];
		
		maxSquare(0, 0, m, n, matrix);
		
		//Calculate largest
		int largest = 0;
		for (int i = 0; i < m-1; i++) {
			for (int j = 0; j < n-1; j++) {
				if (largest < res[i][i]) {
					largest = res[i][j];
				}
			}
		}
		return largest;
    }
	
	
}
