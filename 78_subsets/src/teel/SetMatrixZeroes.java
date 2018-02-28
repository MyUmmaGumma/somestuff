package teel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
	private class Tuple
	{
		int x; int y; public Tuple(int _x, int _y) { x = _x; y = _y;}
	}
	public void setZeroes(int[][] matrix) {
		List<Tuple> lt = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					lt.add(new Tuple(i,j));
					
				}
			}
		}
		System.out.println("Row: " + matrix.length + "Col: " + matrix[0].length);
		for (Tuple t : lt) {
			System.out.println("Row: " + t.x + " Col: " + t.y);
			Arrays.fill(matrix[t.x], 0);
			for (int i = 0; i < matrix.length;i++) {
				matrix[i][t.y] = 0;
			}
		}
		for(int i =0; i < matrix.length;i++) {
		System.out.println(Arrays.toString(matrix[i]));
		}
    }
	
	public static void main(String []args)
	{
		SetMatrixZeroes smz = new SetMatrixZeroes();
		//int [][]matrix = {{0,1}};
		int  [][]matrix = {{0,0,0,5}, {4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		smz.setZeroes(matrix);
	}
}
