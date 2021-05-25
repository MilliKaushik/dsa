package string;

//https://leetcode.com/problems/reverse-words-in-a-string-ii/
public class ReverseWordsInString2 {

	public void reverseWords(char[] s) {
		int i = 0, j = s.length - 1;
		int n = s.length;
		while (i < j) {
			swap(s, i, j);
			i++;
			j--;
		}
		int k = 0;
		while (k < n) {
			int st = k;
			while (k < n && s[k] != ' ')
				k++;
			int end = k - 1;
			reverse(s, st, end);
			k++;
		}
	}

	private void reverse(char[] s, int st, int end) {
		while (st < end) {
			char c = s[st];
			s[st] = s[end];
			s[end] = c;
			st++;
			end--;
		}
	}

	private void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}
