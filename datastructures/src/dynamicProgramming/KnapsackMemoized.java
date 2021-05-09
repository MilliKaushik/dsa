package dynamicProgramming;

//https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#
public class KnapsackMemoized {

	static int W;
	static int n;

	// check if this works
	static int[][] t = new int[n + 1][W + 1];
	static {
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < W + 1; j++)
				t[i][j] = -1;
	}

	static public int knapSack(int[] wt, int[] val, int W, int n) {
		if (n == 0 || W == 0)
			return 0;
		if (t[n][W] != -1)
			return t[n][W];

		if (wt[n - 1] <= W)
			t[n][W] = Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1), knapSack(wt, val, W, n - 1));

		else if (wt[n - 1] > W)
			t[n][W] = knapSack(wt, val, W, n - 1);
		return t[n][W];
	}

}
