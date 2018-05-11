package teel;

import java.util.ArrayList;
import java.util.List;

public class SparseMatrixMultiplication {
	class Node {
		int x,y;
		Node(int i, int j) {
			x = i; y = j;
		}
	}
	
	public int[][] multiply(int[][] A, int[][] B) {
		List<Node> a = new ArrayList<Node>();
		List<Node> b = new ArrayList<Node>();
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				if (A[i][j] != 0)
					a.add(new Node (i,j));
			}
		}
		for(int i = 0; i < B.length; i++) {
			for(int j = 0; j < B[0].length; j++) {
				if (B[i][j] != 0)
					b.add(new Node (i,j));
			}
		}
		int [][]res = new int[A.length][B[0].length];
		
		for(Node aa : a) {
			for(Node bb : b) {
				if (aa.y == bb.x) {
					res[aa.x][bb.y] += A[aa.x][aa.y] * B[bb.x][bb.y];
				}
			}
		}
		return res;
    }
}
