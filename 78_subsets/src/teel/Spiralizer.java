package teel;

import java.util.ArrayList;
import java.util.List;

public class Spiralizer {
	
	private int peelOneLayer(int [][]matrix, List<Integer> li)
	{
		int added = 0;
		return added;
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<Integer>();
        int n = peelOneLayer(matrix, li);
        if (n == 0) {
        	return li;
        }
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[i].length; j++) {
        		
        	}
        }
        return li;
    }
}
