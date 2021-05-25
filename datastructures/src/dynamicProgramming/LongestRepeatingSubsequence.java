package dynamicProgramming;

//check
//https://www.youtube.com/watch?v=hbTaCmQGqLg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30
public class LongestRepeatingSubsequence {

	public int longestRepeatingSubsequence(String a) {
		int n = a.length();
		int[][] t = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == a.charAt(j - 1) && (i != j))
					t[i][j] = 1 + t[i - 1][j - 1];
				else
					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
			}
		}
		return (t[n][n]);
	}
}
