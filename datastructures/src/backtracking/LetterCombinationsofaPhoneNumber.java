package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/explore/interview/card/microsoft/46/backtracking/165/
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/solution/
public class LetterCombinationsofaPhoneNumber {
	private static final Map<Character, String> letters = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6',
			"mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

	private String phoneDigits;
	private List<String> combinations = new ArrayList<>();

	// 23
	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return combinations;
		phoneDigits = digits;
		backtrack(0, new StringBuilder());
		return combinations;
	}

	private void backtrack(int index, StringBuilder path) {
		if (path.length() == phoneDigits.length()) {
			combinations.add(path.toString());
			return;
		}
		String possibleLetters = letters.get(phoneDigits.charAt(index));
		for (char c : possibleLetters.toCharArray()) {
			path.append(c);
			backtrack(index + 1, path);
			path.deleteCharAt(path.length() - 1);
		}
	}
}
