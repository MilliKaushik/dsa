package dynamicProgramming;

//https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25
//heap -> pea : 1 insertion p, 2 deletion h and p from heap. a -> via LCS -> b
//if replace also added here, it becomes edit distance
public class MinimumNumberofInsertionandDeletiontoconvertStringatoStringb {

	public int minimumNumOfInsertionDeletion(String a, String b) {
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
		int noOfDeletions = a.length() - t[m][n];
		int noOfInsertions = b.length() - t[m][n];
		return 0;
	}
}
