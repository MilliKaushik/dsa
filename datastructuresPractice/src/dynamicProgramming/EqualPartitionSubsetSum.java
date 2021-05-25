package dynamicProgramming;

//https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
//KnapSack variation
//https://leetcode.com/problems/partition-equal-subset-sum/
//https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
public class EqualPartitionSubsetSum {

	public boolean isEqualPartitionSumMemoized(int[] arr) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		if (sum % 2 == 0) {
			int[][] t = new int[n + 1][sum / 2 + 1];
			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= sum / 2; j++)
					t[i][j] = -1;
			return isEqualPartitionSumRec(arr, n, sum / 2, t) == 1;
		} else
			return false;
	}

	private int isEqualPartitionSumRec(int[] arr, int n, int halfSum, int[][] t) {
		if (halfSum == 0)
			return 1;
		if (n == 0)
			return 0;
		if (t[n][halfSum] != -1)
			return t[n][halfSum];
		if (arr[n - 1] <= halfSum) {
			if (isEqualPartitionSumRec(arr, n - 1, halfSum - arr[n - 1], t) == 1)
				t[n][halfSum] = 1;
			else if (isEqualPartitionSumRec(arr, n - 1, halfSum, t) == 1)
				t[n][halfSum] = 1;
			// remember to put this line
			else
				t[n][halfSum] = 0;
		} else
			t[n][halfSum] = isEqualPartitionSumRec(arr, n - 1, halfSum, t);
		return t[n][halfSum];
	}

	public boolean isEqualPartitionSUmTabular(int[] arr) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		if (sum % 2 == 0) {
			return canPartitionHelper(arr, n, sum / 2);
		} else
			return false;
	}

	private boolean canPartitionHelper(int[] arr, int n, int halfSum) {
		boolean[][] t = new boolean[n + 1][halfSum + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= halfSum; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;
			}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= halfSum; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= halfSum; j++) {
				System.out.print("t[" + i + "][" + j + "] = " + t[i][j] + " ");
			}
			System.out.println();
		}
		return t[n][halfSum];
	}
}
