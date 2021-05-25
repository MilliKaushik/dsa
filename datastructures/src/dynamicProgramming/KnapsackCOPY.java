package dynamicProgramming;

public class KnapsackCOPY {

	public int knapsackRecursive(int[] wt, int[] price, int W, int n) {
		if (W == 0 || n == 0)
			return 0;
		if (wt[n - 1] <= W)
			return Math.max(price[n - 1] + knapsackRecursive(wt, price, W - wt[n - 1], n - 1),
					knapsackRecursive(wt, price, W, n - 1));
		else
			return knapsackRecursive(wt, price, W, n - 1);
	}

	public int knapSackMemoization(int[] wt, int[] price, int W, int n) {
		int[][] t = new int[W + 1][n + 1];
		for (int i = 0; i <= W; i++)
			for (int j = 0; j <= n; j++)
				if (i == 0 || j == 0)
					t[i][j] = -1;
		return knapSackMemoizationHelper(wt, price, W, n, t);
	}

	public int knapSackMemoizationHelper(int[] wt, int[] price, int W, int n, int[][] t) {
		if (W == 0 || n == 0)
			return 0;
		if (t[W][n] != -1)
			return t[W][n];
		if (wt[n - 1] <= W)
			t[W][n] = Math.max(knapSackMemoizationHelper(wt, price, W - wt[n - 1], n - 1, t),
					knapSackMemoizationHelper(wt, price, W, n - 1, t));
		else
			t[W][n] = knapSackMemoizationHelper(wt, price, W, n - 1, t);
		return t[W][n];
	}

	public int knapSackTopDown(int[] wt, int[] price, int W, int n) {
		int[][] t = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= W; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] <= j) {
					t[i][j] = Math.max(price[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
				} else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][W];
	}

	public boolean subsetSumRecursive(int[] arr, int sum, int n) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		if (arr[n - 1] <= sum)
			return subsetSumRecursive(arr, sum - arr[n - 1], n - 1) || subsetSumRecursive(arr, sum, n - 1);
		else
			return subsetSumRecursive(arr, sum, n - 1);
	}

	public boolean subsetSumTopDown(int[] arr, int sum, int n) {
		boolean[][] t = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][sum];
	}

}
