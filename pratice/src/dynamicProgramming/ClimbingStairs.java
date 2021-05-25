package dynamicProgramming;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/569/
public class ClimbingStairs {

	// Recursive solution - passed 31/45 test cases - should be correct
	public int climbStairsRecursive(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
	}

	// Accepted solution
	public int climbStairsMemoized(int n) {
		int[] stairs = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (n == 1)
				stairs[i] = 1;
			if (n == 2)
				stairs[i] = 2;
			stairs[i] = -1;
		}
		return climbStairsMemoizedHelper(n, stairs);
	}

	private int climbStairsMemoizedHelper(int n, int[] stairs) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (stairs[n] != -1)
			return stairs[n];
		stairs[n - 1] = climbStairsMemoizedHelper(n - 1, stairs);
		stairs[n - 2] = climbStairsMemoizedHelper(n - 2, stairs);
		return stairs[n - 1] + stairs[n - 2];
	}

	// Accepted
	public int climbStairsTabular(int n) {
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;

		int[] stairs = new int[n + 1];
		stairs[0] = 0;
		stairs[1] = 1;
		stairs[2] = 2;

		for (int i = 3; i <= n; i++)
			stairs[i] = stairs[i - 1] + stairs[i - 2];
		return stairs[n];
	}
}
