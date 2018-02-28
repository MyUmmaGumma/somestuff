package teel;

public class CherryPickup {
	public int cherryPickup_int(int[][] grid, int x, int y) {
		int val = 0;
		if (grid[x][y] == 1) {
			grid[x][y] = 0;
			if (x + 1 < grid.length && y + 1 < grid[0].length) {
			    val = 1 + Math.max(cherryPickup_int(grid, x+1, y), cherryPickup_int(grid, x, y+1));
			} else if (x + 1 < grid.length) {
			    val = 1 + cherryPickup_int(grid, x+1, y);
			} else if (y + 1 < grid[0].length) {
			    val = 1 + cherryPickup_int(grid, x, y + 1);
			} else {
				System.out.println(" x = " + x + " y = " + y);
			}
		} else
		if (grid[x][y] == 0) {
			if (x + 1 < grid.length && y + 1 < grid[0].length) {
			    val = Math.max(cherryPickup_int(grid, x+1, y), cherryPickup_int(grid, x, y+1));
			} else if (x + 1 < grid.length) {
			    val = cherryPickup_int(grid, x+1, y);
			} else if (y + 1 < grid[0].length) {
			    val = cherryPickup_int(grid, x, y + 1);
			} else {
				System.out.println(" x = " + x + " y = " + y);
			}
		} else if (grid[x][y] == -1) {
			System.out.println(" x = " + x + " y = " + y);
		}
		return val;
	}
	static 	int count = 0;
	public int cherryPickup(int[][] grid) {
		cherryPickup_int(grid, 0 , 0);
		return count;
    }
	
	private void floodfill(char [][]grid, int x, int y)
	{
		if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && (grid[x][y] == '1')) {
			grid[x][y] = '0';
			floodfill(grid, x+1, y);
			floodfill(grid, x-1, y);
			floodfill(grid, x, y-1);
			floodfill(grid, x, y+1);
		}
	}
}
