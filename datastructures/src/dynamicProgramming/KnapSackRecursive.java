package dynamicProgramming;

//https://www.youtube.com/watch?v=kvyShbFVaY8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3
public class KnapSackRecursive {

	public int knapSack(int[] wt, int[] val, int W, int n) {
		// base condition
		if (n == 0 || W == 0)
			return 0;

		// choice diagram
		if (wt[n - 1] <= W)
			return Math.max(val[n - 1] + knapSack(wt, val, W - wt[n - 1], n - 1), knapSack(wt, val, W, n - 1));
		else //else if(wt[n - 1] > W)
			return knapSack(wt, val, W, n - 1);
	}
}
