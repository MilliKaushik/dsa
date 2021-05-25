package dynamicProgramming;

//https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
//LPS(a) = LCS(a, reverse(a))
public class LongestPalindromicSubsequence {

	public int longestPalindromicSubsequence(String a) {
		int m = a.length();
		String b = reverse(a);
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

	private String reverse(String a) {
		// TODO Auto-generated method stub
		return null;
	}
}
