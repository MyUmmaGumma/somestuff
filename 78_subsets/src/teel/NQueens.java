package teel;

import java.util.ArrayList;
import java.util.List;


public class NQueens {
		private char [][]board;
		int n;
		
		
	
	
	private class QueenPosition {
		public int x;
		public int y;
		QueenPosition(int _x, int _y) {
			x = _x; y = _y;
		}
	}
	
	private void CreateBoard(int _n) {
		n = _n;
		board = new char [n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
	}
	
	private boolean kills(QueenPosition qp, QueenPosition targetPosition, int row)
	{
		if (qp.x == targetPosition.x || qp.y == targetPosition.y || 
				(Math.abs(qp.x - targetPosition.x) == Math.abs(qp.y - targetPosition.y))) {
			return true;
		}
		return false;
	}
	
	private QueenPosition placeQueen(char [][]board, int row, List<QueenPosition> lq, int n, int start)
	{
		
		for (int i = start; i < n; i++) {
			QueenPosition temp = new QueenPosition(row, i);
			boolean killed = false;
			for (QueenPosition qp : lq) {
				if (kills(qp, temp, row)) {
					killed = true;
					break;
				}
			}
			if (killed == false) {
				return temp;
			}
		}
		return null;
	}
	
	private void print2d(String line) {
		if (line != null) {
			System.out.println(line);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		
		if (line != null) {
			System.out.println(line);
		}
	}
	
	
	
    public List<List<String>> solveNQueens(int n) {
    	CreateBoard(n);
    	QueenPosition pos;
    	List<List<QueenPosition>> llq = new ArrayList<List<QueenPosition>>();
    	List<List<String>> lls = new ArrayList<List<String>>();
    	int start = 0;
    	List<QueenPosition> lq = new ArrayList<QueenPosition>();
    	int placed = 0, count = 0; 
	    while (true) {
	    	
	    	
    		
			//print2d(null);
			
    		pos = placeQueen(board, placed, lq, n, start);
    		if (pos == null) {
    			//Backtrack
    			placed--;
    			if (!lq.isEmpty()) {
    				QueenPosition qp = lq.remove(placed);
    				board[qp.x][qp.y] = '.';
    				
    				start = qp.y + 1;
    			} else {
    				//Actual breaking condition
    				break;
    			}
    			
    		} else {
    			lq.add(pos);
    			board[pos.x][pos.y] = 'Q';
    			placed++;
    			start = 0;
    		}
    		if (placed == n) {
    			count++;
    			//print2d("**************");
    			placed--;
    			List<String> ls = new ArrayList<String>();
    			for (int i = 0; i < n; i++) {
    				String s = new String(board[i]);
    				ls.add(s);
    			}
    			lls.add(ls);
    			llq.add(new ArrayList<QueenPosition>(lq));
    			QueenPosition qp = lq.remove(placed);
				board[qp.x][qp.y] = '.';
				start = qp.y + 1;
    		}	
    	}
	    //System.out.println("Total solutions = " + count);
	    
    	return lls;
    }
    
    
    public static void main(String []args)
    {
    	NQueens n = new NQueens();
    	List<List<String>>lls = n.solveNQueens(7);
    }
}


