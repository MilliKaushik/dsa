package dynamicProgramming;

//https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6
//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
public class KnapSackTabular {

	public int knapSack(int W, int[] wt, int[] val, int n) {
		int[][] t = new int[n + 1][W + 1];
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < W + 1; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (wt[i - 1] <= j)
					t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][W];
	}

}
