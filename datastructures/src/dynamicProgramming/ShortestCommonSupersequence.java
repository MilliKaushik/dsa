package dynamicProgramming;

//https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24
//SCS = M + N - LCS
//https://leetcode.com/problems/shortest-common-supersequence/submissions/
public class ShortestCommonSupersequence {

	public int shortestCommonSubsequence(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] t = new int[m][n];
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
		int lcsLen = t[m][n];
		return a.length() + b.length() - lcsLen;
	}

	public String printSCS(String a, String b) {
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
		int i = m, j = n;
		StringBuilder str = new StringBuilder();
		while (i > 0 && j > 0) {
			if (a.charAt(i - 1) == b.charAt(j - 1)) {
				str.append(a.charAt(i - 1));
				i--;
				j--;
			} else {
				// before moving in the direction of the greater element, include this element
				if (t[i - 1][j] < t[i][j - 1]) {
					str.append(b.charAt(j - 1));
					j--;
				} else {
					str.append(a.charAt(i - 1));
					i--;
				}
			}
		}
		str.reverse();
		if (i > 0)
			return a.substring(0, i) + str;
		if (j > 0)
			return b.substring(0, j) + str;
		return str.toString();
	}
}
