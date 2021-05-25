package dynamicProgramming;

//https://leetcode.com/problems/edit-distance/
//https://www.geeksforgeeks.org/edit-distance-dp-5/
public class EditDistance {

	// Let us traverse from right corner, there are two possibilities for every pair
	// of character being traversed.
//m: Length of str1 (first string)
//n: Length of str2 (second string)
//If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
//Else (If last characters are not same), we consider all operations on ‘str1’, consider all three operations on last character of first string, recursively compute minimum cost for all three operations and take minimum of three values. 
//Insert: Recur for m and n-1
//Remove: Recur for m-1 and n
//Replace: Recur for m-1 and n-1
	public int minDistanceMemoized(String word1, String word2) {
		int[][] t = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++)
			for (int j = 0; j <= word2.length(); j++)
				t[i][j] = -1;

		return minDistanceMemoizedHelper(word1, word2, 0, 0, t);
	}

	private int minDistanceMemoizedHelper(String word1, String word2, int m, int n, int[][] t) {
		if (word1.length() == m)
			return word2.length() - n;
		if (word2.length() == n)
			return word1.length() - m;
		if (t[m + 1][n + 1] != -1)
			return t[m + 1][n + 1];
		if (word1.charAt(m) == word2.charAt(n))
			t[m + 1][n + 1] = minDistanceMemoizedHelper(word1, word2, m + 1, n + 1, t);
		else
			t[m + 1][n + 1] = 1 + Math.min(
					Math.min(minDistanceMemoizedHelper(word1, word2, m, n + 1, t),
							minDistanceMemoizedHelper(word1, word2, m + 1, n, t)),
					minDistanceMemoizedHelper(word1, word2, m + 1, n + 1, t));
		return t[m + 1][n + 1];
	}

	public int minDistanceTabular(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= word1.length(); i++)
			for (int j = 0; j <= word2.length(); j++) {
				if (i == 0)
					t[i][j] = j;
				if (j == 0)
					t[i][j] = i;
			}

		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1))
					t[i][j] = t[i - 1][j - 1];
				else
					t[i][j] = 1 + Math.min(Math.min(t[i - 1][j], t[i][j - 1]), t[i - 1][j - 1]);
			}
		return t[m][n];
	}

}
