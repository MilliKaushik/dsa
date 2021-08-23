package dynamicProgramming;

//https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
public class CountNoOfSubsetWithGivenDifference {

	public int countNoOfSubsetWithGivenDifference(int[] arr, int diff) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		// Let s1 and s2 be one of those two subsets.
		// s1 + s2 = sum; s2 - s1 = diff
		// 2 s2 = (sum + diff)/2
		// find no of subsets s2 with given sum as (sum + diff)/2
		if ((sum + diff) % 2 == 0)
			return 0;
		return countSubsetSum(arr, (sum + diff) / 2);
	}

	private int countSubsetSum(int[] arr, int total) {
		int n = arr.length;
		int[][] t = new int[n + 1][total + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= total; j++) {
				if (i == 0)
					t[i][j] = 0;
				if (j == 0)
					t[i][j] = 1;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= total; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][total];
	}
}
