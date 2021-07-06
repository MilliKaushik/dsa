package array.matrix;

//https://www.interviewbit.com/problems/grid-unique-paths/
public class GridUniquePaths {

	public int uniquePaths(int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		int sum = 0;
		sum += backtrack(1, 0, m, n);
		sum += backtrack(0, 1, m, n);
		return sum;
	}

	private int backtrack(int r, int c, int m, int n) {
		if ((r == 0 && c == 0) || (r < 0 || c < 0 || r >= m || c >= n))
			return 0;
		if (r == m - 1 && c == n - 1)
			return 1;
		int sum = 0;
		sum += backtrack(r + 1, c, m, n);
		sum += backtrack(r, c + 1, m, n);
		return sum;
	}
}
