package stack.stackapplications;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/721/
//https://www.interviewbit.com/problems/generate-all-parentheses/
public class BalancedParantheses {

	private final static Map<Character, Character> PARAN_MATCH_MAP = new HashMap<>();
	static {
		PARAN_MATCH_MAP.put(']', '[');
		PARAN_MATCH_MAP.put('}', '{');
		PARAN_MATCH_MAP.put(')', '(');
	}

	public static boolean checkBalancedParathese(String parantheses) {
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
		return stack.isEmpty();
	}

	public static int isValid(String A) {
		if (A.isEmpty())
			return 1;
		Stack<Character> stack = new Stack<>();
		if (A.charAt(0) == '(')
			stack.push(')');
		else if (A.charAt(0) == '{')
			stack.push('}');
		else if (A.charAt(0) == '[')
			stack.push(']');
		else
			return 0;
		int index = 1;
		while (index < A.length()) {
			if (A.charAt(index) == '(')
				stack.push(')');
			else if (A.charAt(index) == '{')
				stack.push('}');
			else if (A.charAt(index) == '[')
				stack.push(']');
			else if (stack.pop() != A.charAt(index))
				return 0;
			index++;
		}
		return stack.isEmpty() ? 1 : 0;
	}
	
	public static void main(String[] args) {
	//	System.out.println(isValid("]"));
		System.out.println(isValid("[]"));
	}
}
