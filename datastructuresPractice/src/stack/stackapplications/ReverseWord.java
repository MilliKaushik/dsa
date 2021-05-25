package stack.stackapplications;

import stack.LinkedListStack;
import stack.Stack;

public class ReverseWord {

	public String reverse(String input) {

		Stack<Character> stack = new LinkedListStack<>();

		for (Character c : input.toCharArray()) {
			stack.push(c);
		}

		StringBuilder str = new StringBuilder();
		while (!stack.isEmpty()) {
			char c = stack.pop();
			str.append(c);
		}
		return str.toString();
	}
}