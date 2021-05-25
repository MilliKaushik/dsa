package dynamicProgramming;

//How to identify if LCS based question? If two strings in input a and b and asking to do some optimal thing like max, min etc
//https://www.youtube.com/watch?v=4dMlCZTONj8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=18
public class LongestCommonSubsequence {

	public int lcsRecursive(String a, String b, int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (a.charAt(m - 1) == b.charAt(n - 1))
			return 1 + lcsRecursive(a, b, m - 1, n - 1);
		else
			return Math.max(lcsRecursive(a, b, m - 1, n), lcsRecursive(a, b, m, n - 1));
	}

	public int lcsMemoized(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				t[i][j] = -1;
			}
		}
		lcsMemoizedHelper(a, b, m, n, t);
		return t[m][n];
	}

	private int lcsMemoizedHelper(String a, String b, int m, int n, int[][] t) {
		if (m == 0 || n == 0)
			return 0;
		if (t[m][n] != -1)
			return t[m][n];
		if (a.charAt(m) == b.charAt(n))
			t[m][n] = 1 + lcsMemoizedHelper(a, b, m - 1, n - 1, t);
		else
			t[m][n] = Math.max(lcsMemoizedHelper(a, b, m - 1, n, t), lcsMemoizedHelper(a, b, m, n - 1, t));
		return t[m][n];
	}

	public int lcsTopDown(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}
		return t[m][n];
	}

	public String printLcs(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] t = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}

		StringBuilder str = new StringBuilder();
		int i = m, j = n;
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				str.append(a.charAt(i - 1));
				i--;
				j--;
			} else {
				if (t[i - 1][j] > t[i][j - 1])
					i--;
				else
					j--;
			}
		}
		return str.reverse().toString();
	}
}
