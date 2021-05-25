package dynamicProgramming;

//https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
//https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
public class CountOfSubsetSumWithGivenSum {

	public int countOfSubsetSum(int[] arr, int sum) {
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
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][sum];
	}
}
