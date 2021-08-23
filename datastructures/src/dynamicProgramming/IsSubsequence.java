package dynamicProgramming;

//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {

	public boolean isSubsequenceRecursion(String s, String t) {
		if (s.isEmpty())
			return true;
		if (t.isEmpty())
			return false;
		int sLen = s.length();
		int tLen = t.length();
		if (s.charAt(sLen - 1) == t.charAt(tLen - 1)) {
			return isSubsequenceRecursion(s.substring(0, sLen - 1), t.substring(0, tLen - 1));
		} else {
			return isSubsequenceRecursion(s.substring(0, sLen), t.substring(0, tLen - 1));
		}
	}

	public boolean isSubsequenceIterative(String s, String t) {
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
