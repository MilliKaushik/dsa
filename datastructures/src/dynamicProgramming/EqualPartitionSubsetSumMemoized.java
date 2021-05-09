package dynamicProgramming;

//https://www.youtube.com/watch?v=UmMh7xp07kY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
//KnapSack variation
//https://leetcode.com/problems/partition-equal-subset-sum/
//https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1
//TLE ON LEETCODE
public class EqualPartitionSubsetSumMemoized {

	public int isEqualPartitionSum(int[] arr) {
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];
		if (sum % 2 == 0) {
			int[][] t = new int[n + 1][sum / 2 + 1];
			for (int i = 0; i <= n; i++)
				for (int j = 0; j <= sum / 2; j++)
					t[i][j] = -1;
			return isEqualPartitionSumRec(arr, n, sum / 2, t);
		} else
			return 0;
	}

	static private int isEqualPartitionSumRec(int[] arr, int n, int halfSum, int[][] t) {
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
		}
		return t[n][halfSum];
	}
}
