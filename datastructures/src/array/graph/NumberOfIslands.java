package array.graph;

//https://www.youtube.com/watch?v=U6-X_QOwPcs
//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

	public int find(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++)
				if (grid[i][j] == '1') {
					count++;
					merge(grid, i, j);
				}
		return count;
	}

	private void merge(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		merge(grid, i - 1, j);
		merge(grid, i, j + 1);
		merge(grid, i + 1, j);
		merge(grid, i, j - 1);
	}
}
