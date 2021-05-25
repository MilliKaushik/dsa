package backtracking;

import java.util.Arrays;

//https://leetcode.com/explore/featured/card/recursion-ii/472/backtracking/2654/
//https://leetcode.com/explore/featured/card/recursion-ii/472/backtracking/2804/
//https://leetcode.com/problems/n-queens-ii/solution/
public class NQueenProblem {

	public static int totalNQueens(int n) {
		int count = 0;
		int[] board = new int[n];
		Arrays.fill(board, -1);

		if (!totalNQueensHelper(board, n, 0))
			return -1;
		return count;
	}

	private static boolean totalNQueensHelper(int[] board, int n, int col) {
		if (col == n)
			return false;
		for (int i = 0; i < n; i++) {
			board[col] = i;
		}

		return false;
	}

	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
		System.out.println(totalNQueens(2));
		System.out.println(totalNQueens(3));
		System.out.println(totalNQueens(4));
	}
}
