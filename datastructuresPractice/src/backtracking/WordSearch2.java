package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/explore/interview/card/microsoft/46/backtracking/256/
public class WordSearch2 {

	public static List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		boolean[][] traversed = new boolean[board.length][board[0].length];

		if (words.length == 0)
			return result;

		for (int k = 0; k < words.length; k++) {
			int row = -1, col = -1;
			boolean isFound = false;
			// finding if the first letter is present in the board
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++)
					if (board[i][j] == words[k].charAt(0)) {
						row = i;
						col = j;
						traversed[i][j] = true;
						if (row != -1 && backtrack(board, words[k], row, col, 1, traversed)) {
							result.add(words[k]);
							isFound = true;
							break;
						}

						// Arrays.fill expects a single-dimensional array
						// https://stackoverflow.com/questions/12573938/the-arrays-fill-method-causes-an-exception
						for (int p = 0; p < board.length; p++)
							Arrays.fill(traversed[p], false);
					}
				if (isFound) {
					for (int p = 0; p < board.length; p++)
						Arrays.fill(traversed[p], false);
					break;
				}
			}
		}
		return result;
	}

	// if a valid solution is found, return true else remove this path and check
	// other paths
	// https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2793/
	private static boolean backtrack(char[][] board, String word, int row, int col, int index, boolean[][] traversed) {
		if (index == word.length())
			return true;

		boolean isWordFound = false;

		if (row < board.length - 1 && !traversed[row + 1][col] && board[row + 1][col] == word.charAt(index)) {
			traversed[row + 1][col] = true;
			isWordFound = backtrack(board, word, row + 1, col, index + 1, traversed);
			if (isWordFound)
				return true;
			traversed[row + 1][col] = false;
		}

		if (row > 0 && !traversed[row - 1][col] && board[row - 1][col] == word.charAt(index)) {
			traversed[row - 1][col] = true;
			isWordFound = backtrack(board, word, row - 1, col, index + 1, traversed);
			if (isWordFound)
				return true;
			traversed[row - 1][col] = false;
		}

		if (col < board[0].length - 1 && !traversed[row][col + 1] && board[row][col + 1] == word.charAt(index)) {
			traversed[row][col + 1] = true;
			isWordFound = backtrack(board, word, row, col + 1, index + 1, traversed);
			if (isWordFound)
				return true;
			traversed[row][col + 1] = false;
		}

		if (col > 0 && !traversed[row][col - 1] && board[row][col - 1] == word.charAt(index)) {
			traversed[row][col - 1] = true;
			isWordFound = backtrack(board, word, row, col - 1, index + 1, traversed);
			if (isWordFound)
				return true;
			traversed[row][col - 1] = false;
		}

		return false;
	}

	public static void main(String[] args) {
//		String[] words = { "oath", "pea", "eat", "rain" };
		// char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i',
		// 'h', 'k', 'r' },
		// { 'i', 'f', 'l', 'v' } };

//		String[] words = { "aa" };
//		char[][] board = { { 'a', 'a' } };

//		char[][] board = { { 'o', 'a', 'b', 'n' }, { 'o', 't', 'a', 'e' }, { 'a', 'h', 'k', 'r' },
//				{ 'a', 'f', 'l', 'v' } };
//		String[] words = { "oa", "oaa" };

		String[] words = { "abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade" };

		char[][] board = { { 'a', 'b', 'c' }, { 'a', 'e', 'd' }, { 'a', 'f', 'g' } };

		System.out.println(findWords(board, words));
	}
}
