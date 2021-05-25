package string;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/882/
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] charCount = new int[26];
		for (int i = 0; i < s.length(); i++)
			charCount[s.charAt(i) - 'a']++;

		for (int j = 0; j < t.length(); j++) {
			char curr = t.charAt(j);
			if (charCount[curr - 'a'] == 0)
				return false;
			charCount[t.charAt(j) - 'a']--;
		}
		for (int k = 0; k < 26; k++)
			if (charCount[k] != 0)
				return false;
		return true;
	}

}
