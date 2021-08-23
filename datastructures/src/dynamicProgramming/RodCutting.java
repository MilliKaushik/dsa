package dynamicProgramming;

public class RodCutting {

	public int rodCutting(int[] val) {
		int n = val.length;
		int[] length = new int[n + 1];
		for (int i = 0; i <= n; i++)
			length[i] = i;
		int[][] t = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (length[i - 1] <= j)
					t[i][j] = Math.max(t[i][j - length[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][n];
	}
}
