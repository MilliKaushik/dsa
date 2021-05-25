package backtracking;

//https://leetcode.com/problems/wildcard-matching/
//https://leetcode.com/problems/wildcard-matching/solution/
//https://www.geeksforgeeks.org/wildcard-pattern-matching/
public class WildcardMatching {

	// Accepted
	public static boolean isMatchDPMemoized(String s, String p) {
		int[][] t = new int[s.length() + 1][p.length() + 1];
		for (int i = 0; i <= s.length(); i++)
			for (int j = 0; j <= p.length(); j++)
				t[i][j] = -1;
		return isMatchDPMemoizedHelper(s, p, s.length(), p.length(), t) == 1;
	}

	private static int isMatchDPMemoizedHelper(String s, String p, int m, int n, int[][] t) {
		if (m == 0 && n == 0)
			return 1;
		if (n == 0)
			return 0;
		if (m == 0) {
			while (n > 0) {
				if (p.charAt(n - 1) != '*')
					return 0;
				n--;
			}
			return 1;
		}
		if (t[m][n] != -1)
			return t[m][n];
		if (p.charAt(n - 1) != '*') {
			if (s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '?')
				t[m][n] = isMatchDPMemoizedHelper(s, p, m - 1, n - 1, t);
			else
				t[m][n] = 0;
		} else {
			if (isMatchDPMemoizedHelper(s, p, m - 1, n, t) == 1)
				t[m][n] = 1;
			else if (isMatchDPMemoizedHelper(s, p, m, n - 1, t) == 1)
				t[m][n] = 1;
			else
				t[m][n] = 0;
		}
		return t[m][n];
	}

	// Accepted solution
	public static boolean isMatchDPTabular(String s, String p) {
		int m = p.length();
		int n = s.length();
		boolean[][] t = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; i++)
			for (int j = 0; j <= n; j++) {
				if (i == 0)
					t[i][j] = false;
				if (j == 0) {
					if (i == 0)
						t[i][j] = true;
					else if (i > 0 && p.charAt(i - 1) != '*')
						t[i][j] = false;
					else if (i > 0 && p.charAt(i - 1) == '*')
						t[i][j] = t[i - 1][j];
				}
			}

		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++) {
				if (p.charAt(i - 1) != '*') {
					if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?')
						t[i][j] = t[i - 1][j - 1];
					else
						t[i][j] = false;
				} else {
					// not t[i - 1][j - 1] - maybe because * and b - then * is an empty space so j -
					// 1 case or * covers the current s char, so i - 1
					t[i][j] = t[i - 1][j] || t[i][j - 1];
				}
			}
		return t[m][n];
	}

	// passes 1710/1804 test cases. Getting TLE
	public static boolean isMatchRecursiveBacktracking(String s, String p) {
		return backtrack(s, p, 0, 0);
	}

	private static boolean backtrack(String s, String p, int i, int j) {
		if (i == s.length() && j == p.length())
			return true;
		if (j == p.length())
			return false;
		if (p.charAt(j) == '?') {
			if (s.length() == i)
				return false;
			return backtrack(s, p, i + 1, j + 1);
		} else if (p.charAt(j) != '*') {
			if (i < s.length())
				return s.charAt(i) == p.charAt(j) && backtrack(s, p, i + 1, j + 1);
			else
				return false;
		} else if (p.charAt(j) == '*') {
			while (j + 1 < p.length() && p.charAt(j + 1) == '*')
				j++;
			j++;
			// there were only *s in j hence, any character whether or not left in s will be
			// covered, hence, we can return true, if not end of j, we need to look for this
			// particular character that we have hit in j
			if (j == p.length())
				return true;
			while (i < s.length()) {
				boolean isFound = backtrack(s, p, i, j);
				if (isFound)
					return true;
				i++;
			}
			// we reached the end of s but didnt find the character in p that we were
			// looking for
			return false;
		}
		return false;
	}

	public static void main(String[] args) {
//		System.out.println(isMatchRecursiveBacktracking("aa", "a"));
//		System.out.println(isMatchRecursiveBacktracking("aa", "*"));
//		System.out.println(isMatchRecursiveBacktracking("cb", "?a"));
//		System.out.println(isMatchRecursiveBacktracking("adcebbbb", "*a*b"));
//		System.out.println(isMatchRecursiveBacktracking("", "**"));
//		System.out.println(isMatchRecursiveBacktracking("", "*"));
//		System.out.println(isMatchRecursiveBacktracking("", "***"));
//		System.out.println(isMatchRecursiveBacktracking("", "******"));
//		System.out.println(isMatchRecursiveBacktracking("abc", "*abc?*"));
//		System.out.println(isMatchRecursiveBacktracking("c", "*?*"));
		// System.out.println(isMatchRecursiveBacktracking(
		// "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
		// "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));

//		System.out.println("---------------------------");
//		System.out.println(isMatchDPTabular("aa", "a"));
//		System.out.println(isMatchDPTabular("aa", "*"));
//		System.out.println(isMatchDPTabular("cb", "?a"));
//		System.out.println(isMatchDPTabular("adcebbbb", "*a*b"));
//		System.out.println(isMatchDPTabular("", "**"));
//		System.out.println(isMatchDPTabular("", "*"));
//		System.out.println(isMatchDPTabular("", "***"));
//		System.out.println(isMatchDPTabular("", "******"));
//		System.out.println(isMatchDPTabular("abc", "*abc?*"));
//		System.out.println(isMatchDPTabular("c", "*?*"));
//		System.out.println(isMatchDPTabular(
//				"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
//				"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));

		// System.out.println("---------------------------");
		// System.out.println("aa -> a" + isMatchDPMemoized("aa", "a"));
		System.out.println("aa -> *" + isMatchDPMemoized("aa", "*"));
//		System.out.println("cb -> ?a" + isMatchDPMemoized("cb", "?a"));
//		System.out.println("adcebbb -> *a*b" + isMatchDPMemoized("adcebbbb", "*a*b"));
//		System.out.println("empty -> **" + isMatchDPMemoized("", "**"));
//		System.out.println("empty -> *" + isMatchDPMemoized("", "*"));
//		System.out.println("empty -> ***" + isMatchDPMemoized("", "***"));
//		System.out.println("empty -> ******" + isMatchDPMemoized("", "******"));
//		System.out.println("abc -> *abc?*" + isMatchDPMemoized("abc", "*abc?*"));
//		System.out.println("c -> *?*" + isMatchDPMemoized("c", "*?*"));
//		System.out.println(isMatchDPMemoized(
//				"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
//				"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
	}
}
