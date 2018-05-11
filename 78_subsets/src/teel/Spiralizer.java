package teel;

import java.util.ArrayList;
import java.util.List;

public class Spiralizer {
	
	private int peelOneLayer(int [][]matrix, List<Integer> li, int k)
	{
		int added = li.size();
		if (matrix.length > k*2) {
		for (int j = k; j < matrix[0].length - k;j++) {
			li.add(matrix[k][j]);
		}
		if (matrix[0].length > k*2) {
		for (int j = k+1; j < matrix.length - k;j++) {
			li.add(matrix[j][matrix[0].length - k - 1]);
		}
		}
		if (k*2 +1 < matrix.length) {
			for (int j = matrix[0].length - k - 2; j >= k;j--) {
				li.add(matrix[matrix.length - k - 1][j]);
			}
		}
		if (k*2 + 1 < matrix[0].length) {
			for (int j = matrix.length - k - 2; j >= k+1;j--) {
				li.add(matrix[j][k]);
			}
		}
		}
		return li.size() - added;
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> li = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return li;
		}
        
        int smaller = Math.min(matrix.length, matrix[0].length);
        
        for (int i = 0; i <= smaller/2;i++) {
        		int n = peelOneLayer(matrix, li, i);
            if (n == 0) {
            		break;
            }
        }
        return li;
    }
	
	public static void main(String []args)
	{
		Spiralizer sp = new Spiralizer();
		 /* int [][]matrix = {
				
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
				
		}; */
		//int [][]matrix = {{2,5,8}, {4,0,-1}};
		 //int [][]matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
		 //int [][]matrix = {{2,3,4},{5,6,7},{8,9,10}, {11,12,13}, {14,15,16}};
		//int [][]matrix = {{1,11},{2,12},{3,13},{4,14}};
		int [][]matrix = {{2},{3}};
		List<Integer> li = sp.spiralOrder(matrix);
		for (Integer i : li) {
			System.out.print(" " + i);
		}
	}
}
