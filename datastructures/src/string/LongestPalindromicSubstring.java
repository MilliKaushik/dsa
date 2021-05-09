package string;

//https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/
public class LongestPalindromicSubstring {

	public String longestPalindrome(String a) {
		String b = reverse(a);
		int n = a.length();
		int[][] t = new int[n + 1][n + 1];

		int maxI = 0;
		int maxJ = 0;
		int maxLen = Integer.MIN_VALUE;

		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				if (i == 0 || j == 0)
					t[i][j] = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					t[i][j] = t[i - 1][j - 1] + 1;
				else
					t[i][j] = 0;

				if (t[i][j] != 0 && maxLen < t[i][j]) {
					maxI = i;
					maxJ = j;
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

	private String reverse(String s) {
		char[] chArray = s.toCharArray();
		int st = 0;
		int end = s.length() - 1;
		while (st < end) {
			char c = chArray[st];
			chArray[st] = chArray[end];
			chArray[end] = c;
			st++;
			end--;
		}
		return new String(chArray);
	}
}
