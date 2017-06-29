/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
*/

private int m;
private int n;


public int numsIslands(char[][] grid) {
	int num = 0; // number of islands
	m = grid.length;  // rows
	n = grid[0].length; // columns
	//corner case

	if(grid == null || m == 0) {
		return 0;
	}

	for(int i = 0; i < m; i++) {
		for(int j = 0; j < n; j++) {
			if (grid[i][j] == '1') {
				helper(grid, i, j);
				num++;
			}
		}
	}

	return num;
}

private void helper(char[][] grid, int x, int y) {
	//corner case
	if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') {
		return;
	}
	grid[x][y] = '0';
	helper(grid, x - 1, y);
	helper(grid, x + 1, y);
	helper(grid, x, y - 1);
	helper(grid, x, y + 1);

	return;
}















