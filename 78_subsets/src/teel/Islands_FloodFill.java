package teel;

public class Islands_FloodFill {
	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					floodfill(grid, i, j);
					count++;
				}
			}
		}
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
