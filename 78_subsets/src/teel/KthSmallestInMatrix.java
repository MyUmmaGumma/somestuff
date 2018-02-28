package teel;

public class KthSmallestInMatrix {
	
	enum DIRECTION {
		RIGHT,
		BOTTOM,
	}
	
	private void heapify(int [][]matrix, int m, int n)
	{
		if (m  == (matrix[0].length -1) && (n  == matrix[0].length -1)) {
			return;
		} else {
			if  (m <= (matrix[0].length -2)) {
				if  (n <= (matrix[0].length -2)) {
					if (matrix[m+1][n] < matrix[m][n+1]) {
						matrix[m][n] = matrix[m+1][n];
						matrix[m+1][n] = Integer.MAX_VALUE;
						heapify(matrix,m+1,n);
					} else {
						matrix[m][n] = matrix[m][n+1];
						matrix[m][n+1] = Integer.MAX_VALUE;
						heapify(matrix,m,n+1);
					}
				} else {
					matrix[m][n] = matrix[m+1][n];
					matrix[m+1][n] = Integer.MAX_VALUE;
					heapify(matrix,m+1,n);
				}
			} else if (n <= (matrix[0].length -2)) {
				if  (m <= (matrix[0].length -2)) {
					if (matrix[m+1][n] < matrix[m][n+1]) {
						matrix[m][n] = matrix[m+1][n];
						matrix[m+1][n] = Integer.MAX_VALUE;
						heapify(matrix,m+1,n);
					} else {
						matrix[m][n] = matrix[m][n+1];
						matrix[m][n+1] = Integer.MAX_VALUE;
						heapify(matrix,m,n+1);
					}
				} else {
					matrix[m][n] = matrix[m][n+1];
					matrix[m][n+1] = Integer.MAX_VALUE;
					heapify(matrix,m,n+1);
				}
			}
		}
	}
	
	
	
	private int nextSmallest(int [][]matrix)
	{
		int smallest = matrix[0][0];
		matrix[0][0] = Integer.MAX_VALUE;
		heapify(matrix, 0, 0);
		System.out.println("Smallest: " + smallest);
		return smallest;
	}
	
	public int kthSmallest(int[][] matrix, int k) {
		int i = 0;
		 while (i < k-1) {
			 i++;
			 nextSmallest(matrix);
		 }
		 
	     return nextSmallest(matrix);
	 }
	 
	 public static void main(String []args)
	 {
		 KthSmallestInMatrix ksma = new KthSmallestInMatrix();
		 int [][]mat = {{1,5,9}, {10,11,13}, {12,13,15}};
		 int [][]mat1 = {{-5}};
		 System.out.println(ksma.kthSmallest(mat1, 1));
	 }
}
