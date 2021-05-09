package dynamicProgramming;

//check logic of printing the substring - works for few cases
//https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
public class LongestCommonSubstring {

	public String longestCommonSubstring(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] t = new int[m + 1][n + 1];

		int maxI = 0;
		int maxLen = 0;

		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = t[i - 1][j - 1] + 1;
				else
					t[i][j] = 0;

				if (maxLen < t[i][j]) {
					maxI = i;
					maxLen = t[i][j];
				}
			}
		}

		StringBuilder str = new StringBuilder();
		int i = maxI;
		while (maxLen-- != 0) {
			str.append(a.charAt(i - 1));
			i--;
		}
		return str.reverse().toString();
	}
}
