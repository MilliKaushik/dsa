package dynamicProgramming;

//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
public class MinimumSubsetSumDifference {

	// find range
	// set s1 + set s2 = range
	// s1 lies on one half of range and s2 on other side

	// Can we only go to half of the range?
	public int minimumSubsetSumDifference(int[] arr) {
		int n = arr.length;
		int range = 0;
		for (int i = 0; i < n; i++)
			range += arr[i];
		boolean[][] t = findSubsetSum(arr, range);
		int min = Integer.MAX_VALUE;
		// here we are trying to find out the maximum value of s1 so that s2 - s1 is
		// minimum
		for (int j = 0; j <= n / 2; j++)
			if (t[n][j])
				min = Math.min(range - j, min);
		return min;
	}

	private boolean[][] findSubsetSum(int[] arr, int range) {
		int n = arr.length;
		boolean[][] t = new boolean[n + 1][range + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= range; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0)
					t[i][j] = true;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= range; j++) {
				if (arr[i - 1] <= j)
					t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t;
	}
}
