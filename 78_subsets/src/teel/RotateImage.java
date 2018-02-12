package teel;

public class RotateImage {
	public void rotate(int[][] matrix) {
		//Move top to bottom, reflect on middle line of matrix
		int start = 0;
		int end = matrix[0].length-1;
		while (start < end) {
			int []temp = matrix[start];
			matrix[start] = matrix[end];
			matrix[end] = temp;
			start++;end--;
		}
		//Reflect on diagonal line of matrix
		for (int i =0 ;i < matrix[0].length;i++) {
			for (int j =i+1 ;j < matrix[0].length;j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;	
			}
		}
    }
	
	public static void main(String []args)
	{
		int [][]arr = {
				{ 5, 1, 9,11},
				{ 2, 4, 8,10},
				{13, 3, 6, 7},
				{15,14,12,16}};
		RotateImage ri = new RotateImage();
		ri.rotate(arr);
		
	}
}
