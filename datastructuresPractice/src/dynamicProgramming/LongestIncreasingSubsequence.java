package dynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/explore/interview/card/microsoft/49/dynamic-programming/156/
//https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
//https://leetcode.com/problems/longest-increasing-subsequence/solution/
public class LongestIncreasingSubsequence {

	// 1 10 20 2 3 4

	// 1 2 10 20 6
	// t 1
	static public int lengthOfLISTabular(int[] arr) {
		int n = arr.length;
		int[] t = new int[n + 1];
		for (int i = 0; i <= n; i++)
			t[i] = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 2; i <= n; i++)
			for (int j = 1; j < i; j++)
				if (arr[i - 1] > arr[j - 1] && t[i] < t[j] + 1)
					t[i] = t[j] + 1;

		for (int i = 0; i <= n; i++)
			max = Math.max(t[i], max);
		return max;
	}

	static public int lengthOfLISMemoized(int[] arr) {
		int n = arr.length;
		int[][] t = new int[n + 1][n];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j < n; j++)
				t[i][j] = -1;
		return lis(arr, -1, 0, t);
	}

	static private int lis(int[] arr, int prevMaxI, int currI, int[][] t) {
		if (currI == arr.length)
			return 0;
		if (t[prevMaxI + 1][currI] >= 0)
			return t[prevMaxI + 1][currI];
		int taken = 0;
		if (prevMaxI < 0 || arr[currI] > arr[prevMaxI])
			taken = 1 + lis(arr, currI, currI + 1, t);
		int notTaken = lis(arr, prevMaxI, currI + 1, t);
		t[prevMaxI + 1][currI] = Math.max(taken, notTaken);
		return t[prevMaxI + 1][currI];
	}

	// TLE - 2 to power n time solution
	// https://leetcode.com/problems/longest-increasing-subsequence/submissions/
	// 22/54 cases passed
	static public int lengthOfLISRecursion1(int[] arr) {
		return lisRecursion1(arr, Integer.MAX_VALUE, arr.length);
	}

	static private int lisRecursion1(int[] arr, int max, int n) {
		if (n == 0)
			return 0;
		int incl = 0;
		if (arr[n - 1] < max)
			incl = 1 + lisRecursion1(arr, arr[n - 1], n - 1);
		int excl = lisRecursion1(arr, max, n - 1);
		return Math.max(incl, excl);
	}

//TLE - https://leetcode.com/submissions/detail/494482359/
	// 22/54 cases passed
	static public int lengthOfLISRecursion2(int[] arr) {
		return lisRecursion2(arr, Integer.MIN_VALUE, 0, arr.length);
	}

	static private int lisRecursion2(int[] arr, int max, int index, int n) {
		if (index == n)
			return 0;
		int incl = 0;
		if (arr[index] > max)
			incl = 1 + lisRecursion2(arr, arr[index], index + 1, n);
		int excl = lisRecursion2(arr, max, index + 1, n);
		return Math.max(incl, excl);
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLISMemoized(new int[] { 1, 2, 1 }));
		System.out.println(lengthOfLISMemoized(new int[] { 1, 10, 20, 6 }));
	}
}
