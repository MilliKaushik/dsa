package string;

//https://leetcode.com/problems/reverse-words-in-a-string/
//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
public class ReverseWordsInString1 {

	public String reverseWords(String s) {
		if (s.length() == 0 || s.length() == 1)
			return s;
		int i = 0, n = s.length();
		StringBuilder reversedSentence = new StringBuilder();
		while (i < n) {
			StringBuilder str = new StringBuilder();
			while (i < n && !isAlphabetOrDigit(s.charAt(i)))
				i++;
			if (i == n)
				break;
			while (i < n && isAlphabetOrDigit(s.charAt(i))) {
				str.append(s.charAt(i));
				i++;
			}
			reversedSentence = str.append(" ").append(reversedSentence);
			i++;
		}
		int len = reversedSentence.length();
		if (reversedSentence.charAt(len - 1) == ' ')
			return reversedSentence.substring(0, len - 1);
		return reversedSentence.toString();
	}

	private boolean isAlphabetOrDigit(char c) {
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))
			return true;
		return false;
	}

}

//		char[] inputCharArr = S.toCharArray();
//		StringBuilder output = new StringBuilder();
//		StringBuilder currStr = new StringBuilder();
//
//		for (int i = inputCharArr.length - 1; i >= 0; i--) {
//			char c = inputCharArr[i];
//			if (c == '.') {
//				output.append(currStr);
//				output.append(".");
//				currStr.append("");
//			} else {
//				currStr.append(c);
//			}
//		}
//		output.append(currStr);
//		return output.toString();
//	}
