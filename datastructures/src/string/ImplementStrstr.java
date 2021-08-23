package string;

//https://leetcode.com/problems/implement-strstr/
//BEST - https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/

//https://bitwangtuo.com/2018/01/04/108/
//http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
public class ImplementStrstr {

//O(m*n)
	public static int strStrBruteForce(String haystack, String needle) {
		if (needle.isEmpty())
			return 0;
		int i = 0, j = 0;
		while (i < haystack.length() && j < needle.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
			if (j == needle.length())
				return i - j;
		}
		return -1;
	}

	public static int strStrKMP(String haystack, String needle) {
		if (needle.isEmpty())
			return 0;

		int[] partialMatchTable = new int[needle.length()];
		partialMatchTable[0] = 0;
		for (int k = 1; k < needle.length(); k++) {

		}
		int i = 0, j = 0;
		while (i < haystack.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			}
			if (j == needle.length())
				return i - j;
			else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
				if (j != 0)
					j = partialMatchTable[j - 1];
				else
					i++;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// System.out.println(strStrBruteForce("abcd", "cd"));
		System.out.println(strStrKMP("abcd", "cd"));
	}
}