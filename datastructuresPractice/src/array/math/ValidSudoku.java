package array.math;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		boolean[] isVisited = new boolean[10];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!checkValidity(board, i, j, isVisited))
					return false;
			}
			for (int p = 0; p < 10; p++)
				isVisited[p] = false;
		}

		for (int j = 0; j < board[0].length; j++) {
			for (int i = 0; i < board.length; i++) {
				if (!checkValidity(board, i, j, isVisited))
					return false;
			}
			for (int p = 0; p < 10; p++)
				isVisited[p] = false;
		}

		for (int m = 0; m < 9; m += 3) {
			for (int n = 0; n < 9; n += 3) {
				for (int i = m; i < m + 3; i++) {
					for (int j = n; j < n + 3; j++) {
						if (!checkValidity(board, i, j, isVisited))
							return false;
					}
				}
				for (int p = 0; p < 10; p++)
					isVisited[p] = false;
			}
		}
		return true;
	}

	private boolean checkValidity(char[][] board, int i, int j, boolean[] isVisited) {
		if (board[i][j] == '.')
			return true;
		int num = Character.getNumericValue(board[i][j]);
		if (isVisited[num])
			return false;
		isVisited[num] = true;
		return true;
	}
}
