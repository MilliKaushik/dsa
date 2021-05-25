package string;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/881/
public class FirstUniqueCharacterinaString {

	public int firstUniqChar(String s) {
		int[] charCount = new int[26];
		int i = 0;
		while (i < s.length()) {
			charCount[s.charAt(i) - 'a']++;
			i++;
		}

		i = 0;
		while (i < s.length()) {
			if (charCount[s.charAt(i) - 'a'] == 1)
				return i;
			i++;
		}
		return -1;
	}
}
