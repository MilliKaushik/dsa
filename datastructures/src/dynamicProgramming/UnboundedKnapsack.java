package dynamicProgramming;

//multiple instances of every item
public class UnboundedKnapsack {

	public int unboundedKnapsack(int[] wt, int[] val, int W) {
		int n = wt.length;
		int[][] t = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					t[i][j] = 0;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] <= W)
					t[i][j] = Math.max(t[i][j - wt[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][W];
	}
}
