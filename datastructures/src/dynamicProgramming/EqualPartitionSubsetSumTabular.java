package dynamicProgramming;

public class EqualPartitionSubsetSumTabular {

	public boolean canPartition(int[] arr) {
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
