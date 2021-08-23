package string;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/887/
public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		String common = longestCommonPrefixFinder(strs[0], strs[1]);
		for (int i = 2; i < strs.length; i++)
			common = longestCommonPrefixFinder(common, strs[i]);
		return common;
	}

	private String longestCommonPrefixFinder(String s1, String s2) {
		int count = 0;
		int i = 0;
		int j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (!(s1.charAt(i) == s2.charAt(j)))
				break;
			count++;
			i++;
			j++;
		}
		return s1.substring(0, count);
	}
}
