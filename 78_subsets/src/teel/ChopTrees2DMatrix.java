package teel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChopTrees2DMatrix {
	private int doBFS(int [][]matrix, int i, Point currPos)
	{
		int x = currPos.x, y = currPos.y;
		int steps = 0;
		List<Point> q = new LinkedList<>();
		q.add(currPos);
		while (!q.isEmpty()) {
			Point p = q.remove(0);
			int j = p.x, k = p.y;
			if (k+1 < matrix[0].length && matrix[j][k+1] != 0) {
				if (matrix[j][k+1] == i) {
					matrix[j][k] = 1;
					currPos = p;
					break;
				} else {
					q.add(new Point(j, k+1));
				}
			}
			if (k-1 > 0 && matrix[j][k-1] != 0) {
				if (matrix[j][k-1] == i) {
					matrix[j][k-1] = 1;
					currPos = p;
					break;
				} else {
					q.add(new Point(j, k-1));
				}
			}
			if (j+1 < matrix.length && matrix[j+1][k] != 0) {
				if (matrix[j+1][k] == i) {
					matrix[j+1][k] = 1;
					currPos = p;
					break;
				} else {
					q.add(new Point(j+1, k));
				}
			}
			if (j-1 > 0 && matrix[j-1][k] != 0) {
				if (matrix[j-1][k] == i) {
					matrix[j-1][k] = 1;
					currPos = p;
					break;
				} else {
					q.add(new Point(j-1, k));
				}
			}
			steps++;
		}
		return steps;
	}
	
	 public int cutOffTree(List<List<Integer>> forest) {
		 List<Integer> li = new ArrayList<>();
		 for (List<Integer> integer : forest) {
			li.addAll(integer);
		 }
		 int m  = forest.size();
		 int n = forest.get(0).size();
		 int [][] matrix = new int [m][];
		 for (int i = 0; i < m; i++) {
			 matrix[i] = new int [n];
		 }
		 
		 Collections.sort(li);
		 int steps = -1, total = -1;
		 Point currPos = new Point(0,0);
		 for (Integer integer : li) {
			if (integer > 1) {
				steps = doBFS(matrix, integer, currPos);
				
			}
		}
		 return total;
	 }
}
