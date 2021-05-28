package string;

//https://leetcode.com/problems/length-of-last-word/
//https://www.interviewbit.com/problems/length-of-last-word/
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		int i = s.length() - 1;
		while (i >= 0 && s.charAt(i) == ' ')
			i--;
		if (i < 0)
			return 0;
		int end = i;
		while (i >= 0 && s.charAt(i) != ' ')
			i--;
		int st = i + 1;
		return end - st + 1;
	}
}
