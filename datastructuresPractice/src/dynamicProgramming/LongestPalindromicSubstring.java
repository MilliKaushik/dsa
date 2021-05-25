package dynamicProgramming;

//brute force is O(n3)
//O(1) space
//Nick White : https://www.youtube.com/watch?v=y2BD4MJqV20
//https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

	public String longestPalindrome(String a) {
		if (a == null || a.length() < 1)
			return "";
		int st = 0, end = 0, len = 0;
		for (int i = 0; i < a.length(); i++) {
			int len1 = expandFromMiddle(a, i, i + 1);
			int len2 = expandFromMiddle(a, i, i);
			len = Math.max(len1, len2);
			if (len > end - st) {
				st = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return a.substring(st, end + 1);
	}

	private int expandFromMiddle(String a, int i, int j) {
		int n = a.length();
		if (i < 0 || i >= n || j < 0 || j >= n)
			return 0;
		while (i >= 0 && j < n && a.charAt(i) == a.charAt(j)) {
			i--;
			j++;
		}
		return j - i - 1;
	}
}
