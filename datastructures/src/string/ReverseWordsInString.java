package string;

//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
public class ReverseWordsInString {

	String reverseWords(String S) {
		char[] inputCharArr = S.toCharArray();
		StringBuilder output = new StringBuilder();
		StringBuilder currStr = new StringBuilder();

		for (int i = inputCharArr.length - 1; i >= 0; i--) {
			char c = inputCharArr[i];
			if (c == '.') {
				output.append(currStr);
				output.append(".");
				currStr.append("");
			} else {
				currStr.append(c);
			}
		}
		output.append(currStr);
		return output.toString();
	}
}
