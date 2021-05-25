package string;

//https://www.interviewbit.com/problems/implement-strstr/
public class StringManipulation {
	// return value if substring is empty
	// return value if substring/string is empty
	// assuming -1 in both cases

	// brute force - O(n^2)
	public int strStrBruteIterative(String str, String substr) {
		if (str.isEmpty() || substr.isEmpty() || substr.length() > str.length())
			return -1;
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == substr.charAt(0)))
				continue;
			int k = 1;
			for (int j = i + 1; j < str.length() && k < substr.length(); j++) {
				if (!(substr.charAt(k) == str.charAt(j)))
					break;
				k++;
			}
			if (k == substr.length())
				return i;
		}
		return -1;
	}

	// TODO
	// https://www.techiedelight.com/implement-strstr-function-java/
	public int strStrBruteRecursive(String str, String substr) {
		if (str.isEmpty() || substr.isEmpty())
			return -1;
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == substr.charAt(i)))
				break;
		}
		if (!(str.charAt(0) == substr.charAt(0)))
			return strStrBruteRecursive(str.substring(1), substr);
		return -1;
	}

	// https://www.interviewbit.com/problems/length-of-last-word/
	public int lengthOfLastWord(final String A) {
		String str = A;
		int length = 0;
		if (str.isEmpty())
			return 0;
		int i = str.length() - 1;
		while (i >= 0 && str.charAt(i) == ' ')
			i--;

		for (; i >= 0; i--) {
			char ch = str.charAt(i);
			if (ch == ' ')
				return length;
			length++;
		}
		return length;
	}

	// https://www.interviewbit.com/problems/reverse-the-string/
	public String reverseWordsInString(String A) {
		String str = A;
		boolean wordFound = false;
		StringBuilder strBuilder = new StringBuilder();
		int endIndex = -1;
		int i = str.length() - 1;
		while (i >= 0) {
			if (str.charAt(i) == ' ') {
				while (i >= 0 && str.charAt(i) == ' ')
					i--;
				if (wordFound) {
					strBuilder.append(str.substring(i + 1, endIndex + 1));
					strBuilder.append(" ");
				}
				wordFound = false;
			} else {
				if (!wordFound && str.charAt(i) != ' ') {
					wordFound = true;
					endIndex = i;
				}
				i--;
			}
		}
		strBuilder.append(str.substring(i + 1, endIndex + 1));
		return strBuilder.toString();
	}
}
