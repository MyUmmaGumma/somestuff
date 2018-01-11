package teel;

public class CaptureXO {
	enum Colors {
		Black, Grey, White, Red;
	}
	
	public int[][] capture(char [][]arr) {
		Colors [][] ret = new Colors[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			ret[i] = new Colors [arr[i].length];
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 'X') {
					ret[i][j] = Colors.Black;
				} else {
					
				}
			}
		}
			return null;
	}
	
	
	public void explore(char[][] arr, int i, int j, Colors [][]visited) {
		int xr = 0,xl = 0, yt= 0, yb = 0;
		if (visited[i][j] == Colors.Grey || visited[i][j] == Colors.Red) {
			return;
		}
		if (i + 1 < arr.length) {
			xr = i+1;
		} else {
			visited[i][j] = Colors.Red;
			return;
		}
		if (i - 1 >= 0) {
			xl = i - 1;
		} else {
			visited[i][j] = Colors.Red;
			return;
		}
		if (j + 1 < arr[i].length) {
			yb = j+1;
		} else {
			visited[i][j] = Colors.Red;
			return;
		}
		if (j - 1 >= 0) {
			yt = j - 1;
		} else {
			visited[i][j] = Colors.Red;
			return;
		}
		 
		visited[i][j] = Colors.Grey;
		if (arr[xr][j] == 'O') {
			System.out.println("Position (" + xr + ", " + j + ") being explored"); 
			explore(arr, xr, j, visited);
		} 
		if(arr[i][yb] == 'O') {
			System.out.println("Position (" + i + ", " + yb + ") being explored");
			explore(arr, i, yb, visited);
		} 
		if (arr[xl][j] == 'O') {
			System.out.println("Position (" + xl + ", " + j + ") being explored");
			explore(arr, xl, j, visited);
		} 
		if (arr[i][yt] == 'O') {
			System.out.println("Position (" + i + ", " + yt + ") being explored");
			explore(arr, i, yt, visited);
		}  
		
		if ((arr[xr][j] == 'X' || visited[xr][j] == Colors.Grey) 
				&& (arr[xl][j] == 'X'|| visited[xl][j] == Colors.Grey) 
				&& (arr[i][yb] == 'X'|| visited[i][yb] == Colors.Grey) 
				&& (arr[i][yt] == 'X' || visited[i][yt] == Colors.Grey)) {
			arr[i][j] = 'X';
			System.out.println("Position (" + i + ", " + j + ") captured!");
			visited[i][j] = Colors.Black;
		}
	}
	
	public void solve(char[][] arr) {
		Colors [][] visited = new Colors[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			visited[i] = new Colors [arr[i].length];
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				visited[i][j] = Colors.White;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] != 'X') {
					System.out.println("Position (" + i + ", " + j + ") being explored"); 
					explore(arr, i, j, visited);
				}
			}	
		}
	}
	
	public static void main(String []args)
	{
		
		char [][]arr = {{'X','X','X','X','X'}, 
						{'X','X','X','O','X'},
						{'X','X','O','O','X'},
						{'X','O','X','X','X'}};
		CaptureXO cxo = new CaptureXO(); 
		cxo.solve(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
