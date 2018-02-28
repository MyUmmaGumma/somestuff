package teel;

public class YoungsTableauSearch {
	
	
	public boolean searchMatrix(int[][] matrix, int target) {
		int x = 0;
		if (matrix.length == 0) return false;
		int y = matrix[0].length -1;
		for (int i =0, j = y; i < matrix.length && j >=0;) {
			
				if (matrix[i][j] == target) {
					return true;
				}
				if (matrix[i][j] < target) {
					i++;
					;
				} else if (matrix[i][j] > target) {
					j--;
					;
				}
			
		}
        return false;
    }
	
	public static void main(String []args)
	{
		YoungsTableauSearch yts = new YoungsTableauSearch();
		int [][]matrix = {
		
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
				
		};
		
		System.out.println(yts.searchMatrix(matrix, 16));
		System.out.println(yts.searchMatrix(matrix, 19));
		System.out.println(yts.searchMatrix(matrix, 22));
		System.out.println(yts.searchMatrix(matrix, 26));
		System.out.println(yts.searchMatrix(matrix, 30));
		System.out.println(yts.searchMatrix(matrix, 23));
		System.out.println(yts.searchMatrix(matrix, 15));
	}
}
