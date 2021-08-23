package dynamicProgramming;

//https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=8
public class SubsetSumProblem {

	static int[][] t = new int[1000][1000];
	static {
		for (int i = 0; i <= 1000; i++)
			for (int j = 0; j <= 1000; j++) {
				t[i][j] = -1;
				if (i == 0)
					t[i][j] = 0;
				if (j == 0)
					t[i][j] = 1;
			}
	}

	// check
	public boolean subsetSumRecursive(int[] arr, int n, int sum) {
		// base condition - if we need sum to be 0, then we will include an empty set
		// hence, even if there are elements in the array, we wont include anything and
		// yet get the subset sum as 0. Hence true.
		if (sum == 0)
			return true;
		// base condition - if no of items is 0, then whatever sum we have(except sum ==
		// 0 which is covered above), we wont be able to get the sum
		if (n == 0)
			return false;
		if (arr[n - 1] <= sum)
			return subsetSumRecursive(arr, n - 1, sum - arr[n - 1]) || subsetSumRecursive(arr, n - 1, sum);
		else // not including this item as it is greater than the sum
			return subsetSumRecursive(arr, n - 1, sum);
	}

	// check
	public boolean subsetSumMemoized(int[] arr, int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0)
			return false;
		if (t[n][sum] != -1)
			return t[n][sum] == 0 ? false : true;
		boolean isSubsetSum;
		if (arr[n - 1] <= sum)
			isSubsetSum = subsetSumMemoized(arr, n - 1, sum - arr[n - 1]) || subsetSumMemoized(arr, n - 1, sum);
		else
			isSubsetSum = subsetSumMemoized(arr, n - 1, sum);
		t[n][sum] = (isSubsetSum == true) ? 1 : 0;
		return isSubsetSum;
	}

	public boolean subsetSumTopDown(int[] arr, int n, int sum) {
		boolean[][] t = new boolean[n + 1][sum + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= sum; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;
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
