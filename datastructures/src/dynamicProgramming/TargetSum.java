package dynamicProgramming;

//https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
public class TargetSum {

	// this is same as finding subset with a given difference
	public int targetSum(int[] arr, int target) {
		// s2 + s1 = range
		// s2 - s1 = target
		// s2 = (range + target)/2
		// question is finding no of subsets with sum as (range + target)/2
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		if ((sum + target) % 2 != 0)
			return 0;
		return countSubsetWithSum(arr, (sum + target) / 2);
	}

	private int countSubsetWithSum(int[] arr, int sum) {
		int n = arr.length;
		int[][] t = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0)
					t[i][j] = 0;
				if (i == 0)
					t[i][j] = 0;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][sum];
	}
}
