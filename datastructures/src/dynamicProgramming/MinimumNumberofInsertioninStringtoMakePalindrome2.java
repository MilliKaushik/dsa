package dynamicProgramming;

//https://www.youtube.com/watch?v=AEcRW4ylm_c&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=32
public class MinimumNumberofInsertioninStringtoMakePalindrome2 {

	public int minimumNumberofInsertioninStringtoMakePalindrome(String a) {
		int lps = longestPalindomicSubsequence(a);
		return a.length() - lps;
	}

	private int longestPalindomicSubsequence(String a) {
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
		return a.length() - t[m][n];
	}

	private String reverse(String a) {
		// TODO Auto-generated method stub
		return null;
	}
}
