package dynamicProgramming;

//https://leetcode.com/problems/is-subsequence/submissions/
//https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=31
public class SequencePatternMatching {
//find if string a is a subsequence of string b
	public boolean findIfOneStringSubsequence(String a, String b) {
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
		return t[m][n] == a.length();
	}

	// this one is faster and uses less space
	public boolean findIfOneStringSubsequenceRecursive(String s, String t) {
		if (s.isEmpty())
			return true;
		if (t.isEmpty())
			return false;
		int sLen = s.length();
		int tLen = t.length();

		int j = 0;
		for (int i = 0; i < tLen; i++) {
			if (s.charAt(j) == t.charAt(i))
				j++;
			if (j == sLen)
				return true;
		}
		return false;
	}
}
