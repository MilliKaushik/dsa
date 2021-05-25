package string;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		char[] chArr = s.toCharArray();
		int st = 0;
		int end = s.length() - 1;
		while (st < end) {
			while (st < s.length() && !isAlphabet(chArr[st]) && !isNumber(chArr[st]))
				st++;
			while (end >= 0 && !isAlphabet(chArr[end]) && !isNumber(chArr[end]))
				end--;
			if (st >= end)
				return true;
			if (isAlphabet(chArr[st]) && isAlphabet(chArr[end])) {
				if (Character.toLowerCase(chArr[st]) != Character.toLowerCase(chArr[end]))
					return false;
			} else if (chArr[st] != chArr[end])
				return false;
			st++;
			end--;
		}
		return true;
	}

	private boolean isAlphabet(char c) {
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
			return true;
		return false;
	}

	private boolean isNumber(char c) {
		if (c >= '0' && c <= '9')
			return true;
		return false;
	}
}
