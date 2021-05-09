package stack.stackapplications;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/721/
public class BalancedParantheses {

	private final static Map<Character, Character> PARAN_MATCH_MAP = new HashMap<>();;
	static {
		PARAN_MATCH_MAP.put(']', '[');
		PARAN_MATCH_MAP.put('}', '{');
		PARAN_MATCH_MAP.put(')', '(');
	}

	public boolean checkBalancedParathese(String parantheses) {
		char[] input = parantheses.toCharArray();
		Stack<Character> stack = new Stack<>();

		for (char p : input) {
			if (PARAN_MATCH_MAP.containsValue(p))
				stack.push(p);
			else {
				if (stack.isEmpty())
					return false;
				else {
					Character top = stack.pop();
					if (!top.equals(PARAN_MATCH_MAP.get(p)))
						return false;
				}
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
}
